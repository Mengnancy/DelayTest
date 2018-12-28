package com.qm.nettylearn.protocol.codec;

import com.qm.nettylearn.protocol.pojo.NettyMessage;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Author: Linglingxin
 * @Date: 2018/12/3 22:29
 */
public class NettyMessageEncoder extends MessageToMessageEncoder<NettyMessage> {
    private MarshallingEncoder marshallingEncoder;

    public NettyMessageEncoder() throws IOException {
        this.marshallingEncoder = new MarshallingEncoder();
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, NettyMessage msg, List<Object> out) throws Exception {
        if (msg == null || msg.getHeader() == null) {
            ByteBuf sendBuf = Unpooled.buffer();
            sendBuf.writeInt(msg.getHeader().getCrcCode());
            sendBuf.writeInt(msg.getHeader().getLength());
            sendBuf.writeLong(msg.getHeader().getSessionID());
            sendBuf.writeByte(msg.getHeader().getType());
            sendBuf.writeByte(msg.getHeader().getPriority());
            sendBuf.writeInt(msg.getHeader().getAttachment().size());

            String key = null;
            byte[] keyArray = null;
            Object value = null;
            for (Map.Entry<String, Object> param : msg.getHeader().getAttachment().entrySet()) {
                key = param.getKey();
                keyArray = key.getBytes("UTF-8");
                sendBuf.writeBytes(keyArray);
                value = param.getValue();
                marshallingEncoder.encode(value, sendBuf);
            }

            key = null;
            keyArray = null;
            value = null;
            if (msg.getBody() != null) {
                marshallingEncoder.encode(msg.getBody(), sendBuf);
            } else {
                sendBuf.writeInt(0);
            }
        }
    }
}
