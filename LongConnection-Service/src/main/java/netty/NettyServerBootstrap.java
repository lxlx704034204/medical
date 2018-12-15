package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import netty.util.PropertyUtil;
import netty.handler.NettyServerHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 陈旭东
 * @version 1.0
 * @date 2018年11月10日
 */
public class NettyServerBootstrap {
    public static int PORT = Integer.parseInt(PropertyUtil.getProperty("PORT").trim()); //1000;    //端口
    final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式

    public NettyServerBootstrap() throws InterruptedException {
        bind();
    }

    private void bind() throws InterruptedException {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, worker);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.option(ChannelOption.SO_BACKLOG, 128);
        //通过NoDelay禁用Nagle,使消息立即发出去，不用等待到一定的数据量才发出去
        bootstrap.option(ChannelOption.TCP_NODELAY, true);
        //保持长连接状态
        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline p = socketChannel.pipeline();
                p.addLast(new ObjectEncoder());
                p.addLast(new ObjectDecoder(ClassResolvers.cacheDisabled(null)));
                p.addLast(new NettyServerHandler());
            }
        });
        ChannelFuture f = bootstrap.bind(PORT).sync();
        if (f.isSuccess()) {
            System.out.println("Netty Server Start! Time:" + dateFormat.format(new Date()));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NettyServerBootstrap bootstrap = new NettyServerBootstrap();
    }
}