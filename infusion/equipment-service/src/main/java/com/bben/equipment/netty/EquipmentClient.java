package com.bben.equipment.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author chenxudong
 * @version 1.0
 * @date 2018年10月20日
 */
public class EquipmentClient {
    private final EquipmentClientHandler clientHandler;

    public EquipmentClient(EquipmentClientHandler clientHandler) {
        this.clientHandler = clientHandler;
    }

    public void connect(String host, int port) throws Exception {
        // 配置客户端NIO线程组
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    //                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 100)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch)
                        throws Exception {
                            ch.pipeline().addLast(clientHandler);
                        }
                    });

            //发起异步服务器连接请求 同步等待成功
            ChannelFuture f = b.connect(host, port).sync();
//            ChannelFuture f = b.connect(host, port).channel().closeFuture().await();

            //等到客户端链路关闭
            f.channel().closeFuture().sync();
        } finally {
            // 优雅退出，释放NIO线程组
            group.shutdownGracefully();
        }
    }

//    /**
//     * @param args
//     * @throws Exception
//     */
//    public static void main(String[] args) throws Exception {
//        String host = "172.30.1.120";
//        int port =4001;
//
//        EquipmentClientHandler clientHandler = new EquipmentClientHandler();
//
//        new EquipmentClient(clientHandler).connect(host, port);
//    }
}
