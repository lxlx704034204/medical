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
 * @date 2018年11月21日
 */
public class SendMsgNoticeClientHandler extends SimpleChannelInboundHandler<BaseMsg> {
    final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        //更新app协议
        MsgNoticeRequest msgNoticeRequest = new MsgNoticeRequest();
        msgNoticeRequest.setClientId("*");     //任意的设备
        msgNoticeRequest.setEquipmentType(SendOrderNettyClient.EquipmentType);
        msgNoticeRequest.setMessage_notice("hao hao hao!00000000000000000000000000");  // 发送通知内容
        ChannelFuture f = ctx.writeAndFlush(msgNoticeRequest);
        f.addListener((ChannelFutureListener) future -> {
            if (future.isSuccess()) {
                System.out.println("MsgNoticeRequest to Server Success! Time:" + dateFormat.format(new Date()));
            } else {
                System.out.println("MsgNoticeRequest to Server Fail! Time:" + dateFormat.format(new Date()));
            }
            System.out.println("--------------------------------------------------");
        });
    }

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, BaseMsg baseMsg) throws Exception {
        MsgType msgType = baseMsg.getType();
        switch (msgType) {
            case PING: {
                System.out.println("receive ping from server!");
            }
            break;

            case MSG_NOTICE: {
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