package com.qm.nettylearn.marshalling;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Author: Linglingxin
 * @Date: 2018/11/29 21:19
 */
public class SubReqClient {
    public static void main(String[] args) throws InterruptedException {
        new SubReqClient().connect("127.0.0.1", 8080);
    }

    private void connect(String host, int port) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(MarshallingCodeFactory.buildMarshallingDecoder());
                            ch.pipeline().addLast(MarshallingCodeFactory.buildMarshallingEncoder());
                            ch.pipeline().addLast(new SubReqClientHandler());
                        }
                    });
            ChannelFuture fu = b.connect(host, port).sync();
            fu.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}
