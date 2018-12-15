package netty;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.SocketChannel;
import netty.protocol.MsgNoticeRequest;
import netty.protocol.VideoRequest;
import netty.util.PropertyUtil;
import netty.connect.ImConnection;
import netty.protocol.RegisterRequest;
import netty.protocol.UpgradeRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 陈旭东
 * @version 1.0
 * @date 2018年11月10日
 */
public class NettyClientBootstrap {
    public static final String HOST = PropertyUtil.getProperty("HOST").trim();  // "127.0.0.1";    //IP地址
    public static int PORT = Integer.parseInt(PropertyUtil.getProperty("PORT").trim());  //1000;                    //端口

    public static final String ClientId = "88888"; //"1234567";   //设备号码

//    public static final String ClientId = PropertyUtil.getProperty("CLIENT_ID").trim(); //"1234567";   //设备号码
    public static final String EquipmentType = PropertyUtil.getProperty("EQUIPMENT_TYPE").trim();  //"1";    //设备类型

    private static SocketChannel socketChannel;
    final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式

//    public static boolean funUpgradeRequest() {
//        AtomicBoolean ok = new AtomicBoolean(false);
//        if (socketChannel != null) {
//            //更新app协议
//            UpgradeRequest upgradeRequest = new UpgradeRequest();
//            upgradeRequest.setClientId(ClientId);
//            upgradeRequest.setEquipmentType(EquipmentType);
//            ChannelFuture f = socketChannel.writeAndFlush(upgradeRequest);
//            f.addListener((ChannelFutureListener) future -> {
//                if (future.isSuccess()) {
//                    ok.set(true);
//                    System.out.println("UpgradeRequest to Server Success! Time:" + dateFormat.format(new Date()));
//                } else {
//                    System.out.println("UpgradeRequest to Server Fail! Time:" + dateFormat.format(new Date()));
//                }
//                System.out.println("--------------------------------------------------");
//            });
//        } else {
//            System.out.println("UpgradeRequest socketChannel is null! Time:" + dateFormat.format(new Date()));
//        }
//
//        return ok.get();
//    }

    public static void main(String[] args) throws InterruptedException {
        ImConnection imConnection = new ImConnection();
        socketChannel = imConnection.connect(HOST, PORT);

        if (socketChannel != null) {
            ChannelFuture f = null;
            //设备注册协议
            RegisterRequest registerRequest = new RegisterRequest();
            registerRequest.setEquipmentType(EquipmentType);
            registerRequest.setClientId(ClientId);
            f = socketChannel.writeAndFlush(registerRequest);
            f.addListener((ChannelFutureListener) future -> {
                if (future.isSuccess()) {
                    System.out.println("RegisterRequest to Server Success! Time:" + dateFormat.format(new Date()));
                } else {
                    System.out.println("RegisterRequest to Server Fail! Time:" + dateFormat.format(new Date()));
                }
                System.out.println("--------------------------------------------------");
            });

            //更新app协议
            UpgradeRequest upgradeRequest = new UpgradeRequest();
            upgradeRequest.setClientId(ClientId);
            upgradeRequest.setEquipmentType(EquipmentType);
            f = socketChannel.writeAndFlush(upgradeRequest);
            f.addListener((ChannelFutureListener) future -> {
                if (future.isSuccess()) {
                    System.out.println("UpgradeRequest to Server Success! Time:" + dateFormat.format(new Date()));
                } else {
                    System.out.println("UpgradeRequest to Server Fail! Time:" + dateFormat.format(new Date()));
                }
                System.out.println("--------------------------------------------------");
            });


            //VideoRequest
            VideoRequest videoRequest = new VideoRequest();
            videoRequest.setClientId(ClientId);
            videoRequest.setEquipmentType(EquipmentType);
            f = socketChannel.writeAndFlush(videoRequest);
            f.addListener((ChannelFutureListener) future -> {
                if (future.isSuccess()) {
                    System.out.println("videoRequest to Server Success! Time:" + dateFormat.format(new Date()));
                } else {
                    System.out.println("videoRequest to Server Fail! Time:" + dateFormat.format(new Date()));
                }
                System.out.println("--------------------------------------------------");
            });


            //MsgNoticeRequest
            MsgNoticeRequest msgNoticeRequest = new MsgNoticeRequest();
            msgNoticeRequest.setClientId(ClientId);
            msgNoticeRequest.setEquipmentType(EquipmentType);
            msgNoticeRequest.setMessage_notice("okokokok");   //通知内容
            f = socketChannel.writeAndFlush(msgNoticeRequest);
            f.addListener((ChannelFutureListener) future -> {
                if (future.isSuccess()) {
                    System.out.println("msgNoticeRequest to Server Success! Time:" + dateFormat.format(new Date()));
                } else {
                    System.out.println("msgNoticeRequest to Server Fail! Time:" + dateFormat.format(new Date()));
                }
                System.out.println("--------------------------------------------------");
            });
        }
    }
}