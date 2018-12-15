package netty.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.util.ReferenceCountUtil;
import netty.base.BaseMsg;
import netty.base.MsgType;
import netty.base.NettyChannelMap;
import netty.config.JDBCDataSource;
import netty.config.JDBCUtils;
import netty.protocol.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 陈旭东
 * @version 1.0
 * @date 2018年11月10日
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<BaseMsg> {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static final AtomicInteger onlineCount = new AtomicInteger(0);
    //    private boolean reduceOnlineCount = true;
    AtomicBoolean reduceOnlineCount = new AtomicBoolean(true);

    final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //channel失效，从Map中移除
        int i = NettyChannelMap.remove((SocketChannel) ctx.channel());
        if (i > 0) {
            if (reduceOnlineCount.get()) {
                int cnt = onlineCount.decrementAndGet();  //在线数减1
                System.out.println("One connection is closed! Current number of online devices:" + cnt);
            }
        }
    }

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, BaseMsg baseMsg) throws Exception {
        ChannelFuture f = null;
        Connection conn = null;
        ResultSet rs = null;

        String equipmentType = baseMsg.getEquipmentType();
        String clientId = baseMsg.getClientId();

        if (MsgType.REGISTER.equals(baseMsg.getType())) {
            RegisterResponse registerResponse = new RegisterResponse();
            registerResponse.setEquipmentType(equipmentType);
            registerResponse.setClientId(clientId);

            //注册成功,把channel存到服务端的map中
            try {
                NettyChannelMap.add(equipmentType + ":" + clientId, (SocketChannel) channelHandlerContext.channel());
                int cnt = onlineCount.incrementAndGet();   //在线数加1
                System.out.println("new connection! current Equipment count:" + cnt + " new SN:" + clientId + " equipment type: " + equipmentType);
                registerResponse.setStatus(0);
            } catch (Exception ex) {
                registerResponse.setStatus(-1);
                ex.printStackTrace();
            }

            f = channelHandlerContext.writeAndFlush(registerResponse);   //回写数据给client端
            f.addListener((ChannelFutureListener) future -> {
                if (future.isSuccess()) {
                    System.out.println("RegisterResponse to Client Success! Time:" + dateFormat.format(new Date()));
                } else {
                    System.out.println("RegisterResponse to Client Fail! Time:" + dateFormat.format(new Date()));
                }
                System.out.println("--------------------------------------------------");
            });
        } else {
            //不是ping和发布消息
            if (!MsgType.PING.equals(baseMsg.getType()) && !MsgType.MSG_NOTICE.equals(baseMsg.getType())) {
                if (clientId == null || clientId.length() == 0) {
                    System.out.println("No device number,no logon system");
                    return;
                }

                if (NettyChannelMap.get(equipmentType + ":" + clientId) == null) {
                    //说明未注册，或者连接断了，服务器向客户端发起登录请求，让客户端重新注册
                    RegisterRequest registerRequest = new RegisterRequest();
                    channelHandlerContext.channel().writeAndFlush(registerRequest);

                    System.out.println("If the connection is not logged in, or the connection is broken, the server sends a login request to the client for the client to log in again.");
                }
            }
        }

        switch (baseMsg.getType()) {
            case PING: {
//                PingMsg pingMsg = (PingMsg) baseMsg;
                PingMsg replyPing = new PingMsg();

                f = channelHandlerContext.writeAndFlush(replyPing);   //回写数据给client端
                f.addListener((ChannelFutureListener) future -> {
                    if (future.isSuccess()) {
                        System.out.println("PingMsg to Client Success! Time:" + dateFormat.format(new Date()));
                    } else {
                        System.out.println("PingMsg to Client Fail! Time:" + dateFormat.format(new Date()));
                    }
                    System.out.println("--------------------------------------------------");
                });
            }
            break;

            //app应用程序升级协议
            case UPGRADE: {
                UpgradeRequest upgradeRequest = (UpgradeRequest) baseMsg;
                UpgradeResponse upgradeResponse = new UpgradeResponse();

                //1 = 代表自己，2=代表其他端来升级系统
                Integer upgradeValue = upgradeRequest.getUpgradeMode() == null ? 1 : upgradeRequest.getUpgradeMode();
                reduceOnlineCount.set(upgradeValue == 1 ? true : false);

                //查找数据库是否有新版本更新，如果有就提示更新，否则不提示更新。成功返回更新的app升级包地址
                upgradeResponse.setClientId(upgradeRequest.getClientId());
                upgradeResponse.setEquipmentType(upgradeRequest.getEquipmentType());

                conn = JDBCDataSource.getInstance().getConnection();
                //查找数据库版本信息，如果有就写入，否则返回错误
                String sql = "SELECT soft_name,full_version,version,folder_url from t_version where soft_type =? ORDER BY version desc LIMIT 1";
                PreparedStatement statement = null;

                try {
                    statement = conn.prepareStatement(sql);
                    statement.setString(1, upgradeRequest.getEquipmentType());

                    rs = statement.executeQuery();
                    while (rs.next()) {
                        String f1 = rs.getString("soft_name").trim();
                        String f2 = rs.getString("full_version").trim();
                        String f3 = rs.getString("folder_url").trim();
                        String f4 = rs.getString("version").trim();

                        upgradeResponse.setAppPath(f3);
                        upgradeResponse.setVersion(Integer.parseInt(f4));
                        upgradeResponse.setStatus(0);
                        System.out.println(f3 + " " + f2 + "  " + f1 + " " + f4);
                        break;
                    }
                } catch (SQLException e) {
                    upgradeResponse.setStatus(-1);
                    e.printStackTrace();
                } finally {
                    JDBCUtils.release(rs, statement, conn);
                }

                Channel channel = NettyChannelMap.get(upgradeRequest.getEquipmentType() + ":" + upgradeRequest.getClientId());
                if (channel != null) {
                    f = channel.writeAndFlush(upgradeResponse);   //回写数据给client端
                    f.addListener((ChannelFutureListener) future -> {
                        if (future.isSuccess()) {
                            System.out.println("UpgradeResponse to Client Success! Time:" + dateFormat.format(new Date()));
                        } else {
                            System.out.println("UpgradeResponse to Client Fail! Time:" + dateFormat.format(new Date()));
                        }
                        System.out.println("--------------------------------------------------");
                    });
                }
            }
            break;

            //语音协议
            case VOICE: {
                VoiceRequest voiceRequest = (VoiceRequest) baseMsg;
                VoiceResponse voiceResponse = new VoiceResponse();
                voiceResponse.setClientId(voiceRequest.getClientId());
                voiceResponse.setEquipmentType(voiceRequest.getEquipmentType());

                Channel channel = NettyChannelMap.get(voiceRequest.getEquipmentType() + ":" + voiceRequest.getClientId());
                if (channel != null) {
                    f = channel.writeAndFlush(voiceRequest);   //回写数据给client端
                    f.addListener((ChannelFutureListener) future -> {
                        if (future.isSuccess()) {
                            voiceResponse.setStatus(0);
                            System.out.println("Forward voice to Client Success! Time:" + dateFormat.format(new Date()));
                        } else {
                            voiceResponse.setStatus(-1);
                            System.out.println("Forward voice to Client Fail! Time:" + dateFormat.format(new Date()));
                        }
                        System.out.println("--------------------------------------------------");
                    });
                }

                //回复请求者
                channelHandlerContext.writeAndFlush(voiceResponse);
            }
            break;

            //取消语音协议
            case CANCEL_VOICE: {
                CancelVoiceRequest cancelVoiceRequest = (CancelVoiceRequest) baseMsg;
                CancelVoiceResponse cancelVoiceResponse = new CancelVoiceResponse();

                cancelVoiceResponse.setClientId(cancelVoiceRequest.getClientId());
                cancelVoiceResponse.setEquipmentType(cancelVoiceRequest.getEquipmentType());

                Channel channel = NettyChannelMap.get(cancelVoiceRequest.getEquipmentType() + ":" + cancelVoiceRequest.getClientId());
                if (channel != null) {
                    f = channel.writeAndFlush(cancelVoiceRequest);   //回写数据给client端
                    f.addListener((ChannelFutureListener) future -> {
                        if (future.isSuccess()) {
                            cancelVoiceResponse.setStatus(0);
                            System.out.println("CancelVoiceResponse to Client Success! Time:" + dateFormat.format(new Date()));
                        } else {
                            cancelVoiceResponse.setStatus(-1);
                            System.out.println("CancelVoiceResponse to Client Fail! Time:" + dateFormat.format(new Date()));
                        }
                        System.out.println("--------------------------------------------------");
                    });
                }
                //回复请求者
                channelHandlerContext.writeAndFlush(cancelVoiceResponse);
            }
            break;

            //视频
            case VIDEO: {
                VideoRequest videoRequest = (VideoRequest) baseMsg;
                VideoResponse videoResponse = new VideoResponse();

                videoResponse.setClientId(videoRequest.getClientId());
                videoResponse.setEquipmentType(videoRequest.getEquipmentType());

                Channel channel = NettyChannelMap.get(videoRequest.getEquipmentType() + ":" + videoRequest.getClientId());
                if (channel != null) {
                    f = channel.writeAndFlush(videoRequest);   //回写数据给client端
                    f.addListener((ChannelFutureListener) future -> {
                        if (future.isSuccess()) {
                            videoResponse.setStatus(0);
                            System.out.println("Forward video to Client Success! Time:" + dateFormat.format(new Date()));
                        } else {
                            videoResponse.setStatus(-1);
                            System.out.println("Forward video to Client Fail! Time:" + dateFormat.format(new Date()));
                        }
                        System.out.println("--------------------------------------------------");
                    });
                }

                //回复请求者
                channelHandlerContext.writeAndFlush(videoResponse);
            }
            break;

            //取消视频
            case CANCEL_VIDEO: {
                CancelVideoRequest cancelVideoRequest = (CancelVideoRequest) baseMsg;
                CancelVideoResponse cancelVideoResponse = new CancelVideoResponse();

                cancelVideoResponse.setClientId(cancelVideoRequest.getClientId());
                cancelVideoResponse.setEquipmentType(cancelVideoRequest.getEquipmentType());

                Channel channel = NettyChannelMap.get(cancelVideoRequest.getEquipmentType() + ":" + cancelVideoRequest.getClientId());
                if (channel != null) {
                    f = channel.writeAndFlush(cancelVideoRequest);   //回写数据给client端
                    f.addListener((ChannelFutureListener) future -> {
                        if (future.isSuccess()) {
                            cancelVideoResponse.setStatus(0);
                            System.out.println("CancelVideoResponse to Client Success! Time:" + dateFormat.format(new Date()));
                        } else {
                            cancelVideoResponse.setStatus(-1);
                            System.out.println("CancelVideoResponse to Client Fail! Time:" + dateFormat.format(new Date()));
                        }
                        System.out.println("--------------------------------------------------");
                    });
                }

                //回复请求者
                channelHandlerContext.writeAndFlush(cancelVideoResponse);
            }
            break;

            //消息推送协议
            case MSG_NOTICE: {
                MsgNoticeRequest msgNoticeRequest = (MsgNoticeRequest) baseMsg;
//                MsgNoticeResponse msgNoticeResponse = new MsgNoticeResponse();
//                msgNoticeResponse.setClientId(msgNoticeRequest.getClientId());
//                msgNoticeResponse.setEquipmentType(msgNoticeRequest.getEquipmentType());
                System.out.println("MsgNoticeRequest Data:" + msgNoticeRequest.getMessage_notice());
                String tmpClientId = msgNoticeRequest.getClientId();
                String equip_type = msgNoticeRequest.getEquipmentType();

                if (tmpClientId.length() == 0 || tmpClientId.equals("*")) {
                    for (Map.Entry entry : NettyChannelMap.map.entrySet()) {
                        //还需要添加设备类型限制
                        String key = entry.getKey().toString();
                        if (key.startsWith(equip_type)) {
                            SocketChannel tmpchannel = (SocketChannel) entry.getValue();
                            f = tmpchannel.writeAndFlush(msgNoticeRequest);  //回写数据给client端
                            f.addListener((ChannelFutureListener) future -> {
                                if (future.isSuccess()) {
                                    System.out.println("Forward msgNotice to Client Success! Time:" + dateFormat.format(new Date()));
                                } else {
                                    System.out.println("Forward msgNotice to Client Fail! Time:" + dateFormat.format(new Date()));
                                }
                                System.out.println("--------------------------------------------------");
                            });
                        } else {
                            break;
                        }
                    }
                } else {
                    Channel channel = NettyChannelMap.get(msgNoticeRequest.getEquipmentType() + ":" + msgNoticeRequest.getClientId());
                    if (channel != null) {
                        f = channel.writeAndFlush(msgNoticeRequest);   //回写数据给client端
                        f.addListener((ChannelFutureListener) future -> {
                            if (future.isSuccess()) {
//                        msgNoticeResponse.setStatus(0);
                                System.out.println("Forward msgNotice to Client Success! Time:" + dateFormat.format(new Date()));
                            } else {
//                        msgNoticeResponse.setStatus(-1);
                                System.out.println("Forward msgNotice to Client Fail! Time:" + dateFormat.format(new Date()));
                            }
                            System.out.println("--------------------------------------------------");
                        });
                    }
                }

                //回复请求者
//                channelHandlerContext.writeAndFlush(msgNoticeResponse);
            }
            break;

            //锁屏协议
            case LOCK_SCREEN: {
                LockScreenRequest lockScreenRequest = (LockScreenRequest) baseMsg;
                LockScreenResponse lockScreenResponse = new LockScreenResponse();
                lockScreenResponse.setClientId(lockScreenRequest.getClientId());
                lockScreenResponse.setEquipmentType(lockScreenRequest.getEquipmentType());

                Channel channel = NettyChannelMap.get(lockScreenRequest.getEquipmentType() + ":" + lockScreenRequest.getClientId());
                if (channel != null) {
                    f = channel.writeAndFlush(lockScreenRequest);   //回写数据给client端
                    f.addListener((ChannelFutureListener) future -> {
                        if (future.isSuccess()) {
                            lockScreenResponse.setStatus(0);
                            System.out.println("Forward LockScreenRequest to Client Success! Time:" + dateFormat.format(new Date()));
                        } else {
                            lockScreenResponse.setStatus(-1);
                            System.out.println("Forward LockScreenRequest to Client Fail! Time:" + dateFormat.format(new Date()));
                        }
                        System.out.println("--------------------------------------------------");
                    });
                }

                //回复请求者
                channelHandlerContext.writeAndFlush(lockScreenResponse);
            }
            break;
            default:
                System.out.println("default");
                break;
        }
        if (conn != null) {
            conn.close();
        }
        ReferenceCountUtil.release(baseMsg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        closeOnFlush(ctx.channel());  // 发生异常，关闭链路
    }

    static void closeOnFlush(Channel ch) {
        if (ch.isActive()) {
            ch.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
        }
    }
}