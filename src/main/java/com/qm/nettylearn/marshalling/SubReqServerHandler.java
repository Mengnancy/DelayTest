package com.qm.nettylearn.marshalling;

import com.qm.nettylearn.protobuf.SubscribeReqProto;
import com.qm.nettylearn.protobuf.SubscribeRespProto;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @Author: Linglingxin
 * @Date: 2018/11/29 21:12
 */
public class SubReqServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        UserInfo req = (UserInfo) msg;
        if ("nancy".equals(req.getName())) {
            System.out.println("Service accept client subscribe req : [" + req.toString() + "]");
            ctx.writeAndFlush(resp(req.getAge()));
        }
    }

    private UserInfo resp(int subReqID) {
        UserInfo info = new UserInfo();
        info.setAge(subReqID);
        info.setName("nancy");
        return info;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
