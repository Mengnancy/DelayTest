package com.qm.nettylearn.msgpack;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandlerInvoker;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * @Author: Linglingxin
 * @Date: 2018/11/28 22:29
 */
public class EchoHandler extends ChannelHandlerAdapter {
    private int sendNumber;

    public EchoHandler(int sendNumber) {
        this.sendNumber = sendNumber;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        UserInfo[] infos = userInfos();
        for (UserInfo info : infos) {
            ctx.write(info);
        }
//        ctx.write(infos);
        ctx.flush();
    }

    private UserInfo[] userInfos() {
        UserInfo[] infos = new UserInfo[sendNumber];
        for (int i = 0; i < sendNumber; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setAge(i);
            userInfo.setName("ABCDEFG -->" + i);
            infos[i] = userInfo;
        }
        return infos;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Client receive the msgpack message" + msg);
//        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
