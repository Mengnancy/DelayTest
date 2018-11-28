package com.qm.nettylearn.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @Author: Linglingxin
 * @Date: 2018/11/28 22:29
 */
public class EchoServerHandler extends ChannelHandlerAdapter {
    private int sendNumber;

    public EchoServerHandler(int sendNumber) {
        this.sendNumber = sendNumber;
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
        System.out.println("Server receive the msgpack message" + msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(1000);
        userInfo.setName("ABCDEFG -->" + 1000);
        ctx.write(userInfo);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
