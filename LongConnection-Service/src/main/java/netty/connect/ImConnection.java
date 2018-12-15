package netty.connect;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import netty.NettyClientBootstrap;
import netty.handler.NettyClientHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author 陈旭东
 * @version 1.0
 * @date 2018年11月10日
 */

public class ImConnection {
    private SocketChannel socketChannel;
    final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式

    public SocketChannel connect(String host, int port) {
        doConnect(host, port);
        return this.socketChannel;
    }

    private void doConnect(String host, int port) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.group(eventLoopGroup);
            bootstrap.remoteAddress(host, port);
            bootstrap.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    /**
                     ch.pipeline().addLast("ping", new IdleStateHandler(60, 20, 60 * 10, TimeUnit.SECONDS));
                     第一个参数 60 表示读操作空闲时间
                     第二个参数 20 表示写操作空闲时间
                     第三个参数 60*10 表示读写操作空闲时间
                     第四个参数 单位/秒
                     */
                    ch.pipeline().addLast(new IdleStateHandler(20, 10, 0));
                    ch.pipeline().addLast(new ObjectEncoder());
                    ch.pipeline().addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
                    ch.pipeline().addLast(new NettyClientHandler());
                }
            });

            ChannelFuture future = bootstrap.connect(host, port).sync();
            if (future.isSuccess()) {
                socketChannel = (SocketChannel) future.channel();
                System.out.println("Connect Server Success! Time:" + dateFormat.format(new Date()));
            } else {
                final EventLoop loop = future.channel().eventLoop();
                loop.schedule(() -> {
                    System.err.println("服务端链接不上，开始重连操作...");
                    connect(NettyClientBootstrap.HOST, NettyClientBootstrap.PORT);
                }, 2L, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                TimeUnit.SECONDS.sleep(3);
                connect(NettyClientBootstrap.HOST, NettyClientBootstrap.PORT);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
}