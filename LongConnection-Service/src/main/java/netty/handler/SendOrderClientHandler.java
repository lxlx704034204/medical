package netty.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.util.ReferenceCountUtil;
import netty.NettyClientBootstrap;
import netty.SendOrderNettyClient;
import netty.base.BaseMsg;
import netty.base.MsgType;
import netty.protocol.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 陈旭东
 * @version 1.0
 * @date 2018年11月10日
 */
public class SendOrderClientHandler extends SimpleChannelInboundHandler<BaseMsg> {
    final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        //更新app协议
        UpgradeRequest upgradeRequest = new UpgradeRequest();
        upgradeRequest.setClientId(SendOrderNettyClient.ClientId);
        upgradeRequest.setEquipmentType(SendOrderNettyClient.EquipmentType);
        upgradeRequest.setUpgradeMode(2);  //1 = 代表自己，2=代表其他端来升级系统
        ChannelFuture f = ctx.writeAndFlush(upgradeRequest);
        f.addListener((ChannelFutureListener) future -> {
            if (future.isSuccess()) {
                System.out.println("UpgradeRequest to Server Success! Time:" + dateFormat.format(new Date()));
            } else {
                System.out.println("UpgradeRequest to Server Fail! Time:" + dateFormat.format(new Date()));
            }
            System.out.println("--------------------------------------------------");
        });
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

            default:
                System.out.println("default");
                break;
        }
        ReferenceCountUtil.release(msgType);
        closeOnFlush(channelHandlerContext.channel());
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