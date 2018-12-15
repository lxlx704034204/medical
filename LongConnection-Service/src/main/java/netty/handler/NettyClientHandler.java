package netty.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import netty.NettyClientBootstrap;
import netty.base.BaseMsg;
import netty.base.MsgType;
import netty.connect.ImConnection;
import netty.protocol.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author 陈旭东
 * @version 1.0
 * @date 2018年11月10日
 */
public class NettyClientHandler extends SimpleChannelInboundHandler<BaseMsg> {
    final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
    private ImConnection imConnection = new ImConnection();

    //利用写空闲发送心跳检测消息
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        ChannelFuture f = null;

        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case WRITER_IDLE:
                    PingMsg pingMsg = new PingMsg();
                    pingMsg.setClientId(NettyClientBootstrap.ClientId);

                    f = ctx.writeAndFlush(pingMsg);
                    f.addListener((ChannelFutureListener) future -> {
                        if (future.isSuccess()) {
                            System.out.println("Send ping to Server... Success! Time:" + dateFormat.format(new Date()));
                        } else {
                            System.out.println("Send ping to Server... Fail! Time:" + dateFormat.format(new Date()));
                        }
                        System.out.println("--------------------------------------------------");
                    });

                    break;

                case READER_IDLE:
                    System.out.println("长期没收到服务器推送数据");
                    //可以选择重新连接

                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //使用过程中断线重连
        final EventLoop eventLoop = ctx.channel().eventLoop();
        eventLoop.schedule(() -> {
            imConnection.connect(NettyClientBootstrap.HOST, NettyClientBootstrap.PORT);
        }, 2L, TimeUnit.SECONDS);
        super.channelInactive(ctx);
    }

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, BaseMsg baseMsg) throws Exception {
        MsgType msgType = baseMsg.getType();
        switch (msgType) {
            case REGISTER: {
                if (baseMsg instanceof RegisterResponse) {
                    RegisterResponse registerResponse = (RegisterResponse) baseMsg;
                    System.out.println("RegisterResponse:" + registerResponse.getClientId());
                } else {
                    //向服务器发起注册
                    RegisterRequest registerRequest = new RegisterRequest();
                    registerRequest.setEquipmentType(NettyClientBootstrap.EquipmentType);
                    registerRequest.setClientId(NettyClientBootstrap.ClientId);
                    channelHandlerContext.writeAndFlush(registerRequest);

                    System.out.println("RegisterRequest");
                }
            }
            break;
            case PING: {
                System.out.println("receive ping from server!");
            }
            break;

            case UPGRADE: {
                if (baseMsg instanceof UpgradeResponse) {
                    UpgradeResponse upgradeResponse = (UpgradeResponse) baseMsg;
                    System.out.println("UpgradeResponse ClientId:" + upgradeResponse.getClientId() + " AppPath:" + upgradeResponse.getAppPath() + " version:" + upgradeResponse.getVersion() + " type:" + upgradeResponse.getEquipmentType());
                }
            }
            break;

            case VOICE: {
                if (baseMsg instanceof VoiceRequest) {
                    VoiceRequest voiceRequest = (VoiceRequest) baseMsg;
                    System.out.println("VoiceRequest ClientId:" + voiceRequest.getClientId() + " type:" + voiceRequest.getType() + " EquipmentType:" + voiceRequest.getEquipmentType());
                }

                if (baseMsg instanceof VoiceResponse) {
                    VoiceResponse voiceResponse = (VoiceResponse) baseMsg;
                    System.out.println("VoiceResponse ClientId:" + voiceResponse.getClientId() + " Status:" + voiceResponse.getStatus() + " type:" + voiceResponse.getType() + " EquipmentType:" + voiceResponse.getEquipmentType());
                }
            }
            break;

            case VIDEO: {
                if (baseMsg instanceof VideoRequest) {
                    VideoRequest videoRequest = (VideoRequest) baseMsg;
                    System.out.println("videoRequest ClientId:" + videoRequest.getClientId() + " type:" + videoRequest.getType() + " EquipmentType:" + videoRequest.getEquipmentType());
                }

                if (baseMsg instanceof VideoResponse) {
                    VideoResponse videoResponse = (VideoResponse) baseMsg;
                    System.out.println("videoResponse ClientId:" + videoResponse.getClientId() + " Status:" + videoResponse.getStatus() + " type:" + videoResponse.getType() + " EquipmentType:" + videoResponse.getEquipmentType());
                }
            }
            break;

            case MSG_NOTICE: {
                if (baseMsg instanceof MsgNoticeRequest) {
                    MsgNoticeRequest msgNoticeRequest = (MsgNoticeRequest) baseMsg;
                    System.out.println("MsgNoticeRequest ClientId:" + msgNoticeRequest.getClientId() + " EquipmentType:" + msgNoticeRequest.getEquipmentType() + " Data:" + msgNoticeRequest.getMessage_notice());
                }

                if (baseMsg instanceof MsgNoticeResponse) {
                    MsgNoticeResponse msgNoticeResponse = (MsgNoticeResponse) baseMsg;
                    System.out.println("MsgNoticeResponse ClientId:" + msgNoticeResponse.getClientId() + " EquipmentType:" + msgNoticeResponse.getEquipmentType() + " status:" + msgNoticeResponse.getStatus());
                }
            }
            break;

            default:
                System.out.println("default");
                break;
        }
        ReferenceCountUtil.release(msgType);

//        channelHandlerContext.close(); //这个不能关闭，否则就失去了连接
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