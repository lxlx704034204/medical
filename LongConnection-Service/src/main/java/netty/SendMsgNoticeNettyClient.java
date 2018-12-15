package netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import netty.handler.SendMsgNoticeClientHandler;
import netty.handler.SendOrderClientHandler;
import netty.util.PropertyUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 陈旭东
 * @version 1.0
 * @date 2018年11月10日
 * 发送通知信息给在线客户端
 */
public class SendMsgNoticeNettyClient {
    public static final String HOST = PropertyUtil.getProperty("HOST").trim();  // "127.0.0.1";    //IP地址
    public static int PORT = Integer.parseInt(PropertyUtil.getProperty("PORT").trim());  //1000;                    //端口

    public static final String ClientId = PropertyUtil.getProperty("CLIENT_ID").trim(); //"1234567";   //设备号码
    public static final String EquipmentType = PropertyUtil.getProperty("EQUIPMENT_TYPE").trim();  //"1";    //设备类型

    //    private static SocketChannel socketChannel;
    final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式

    public void connect(String host, int port) throws Exception {
        // 配置客户端NIO线程组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            ch.pipeline().addLast(
                                    new ObjectEncoder(),
                                    new ObjectDecoder(ClassResolvers.cacheDisabled(null)),
                                    new SendMsgNoticeClientHandler());
                        }
                    });

            // 发起异步连接操作
            ChannelFuture f = b.connect(host, port).sync();
            if (f.isSuccess()) {
                System.out.println("Connect Server Success! Time:" + dateFormat.format(new Date()));
            }
            // 当代客户端链路关闭
            f.channel().closeFuture();
        } finally {
            // 优雅退出，释放NIO线程组
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        SendMsgNoticeNettyClient sendOrderNettyClient = new SendMsgNoticeNettyClient();
        sendOrderNettyClient.connect(HOST, PORT);
    }
}