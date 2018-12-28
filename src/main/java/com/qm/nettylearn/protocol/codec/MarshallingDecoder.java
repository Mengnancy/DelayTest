package com.qm.nettylearn.protocol.codec;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteInput;
import org.jboss.marshalling.Unmarshaller;

import java.io.IOException;

/**
 * @Author: Linglingxin
 * @Date: 2018/12/3 23:00
 */
public class MarshallingDecoder {
    private final Unmarshaller unmarshaller;

    public MarshallingDecoder() throws IOException {
        this.unmarshaller = MarshallingCodecFactory.buildUnMarshalling();
    }

    protected Object decode(ByteBuf in) throws IOException, ClassNotFoundException {
        int objectSize = in.readInt();
        ByteBuf buf = in.slice(in.readerIndex(), objectSize);
        ByteInput input = new ChannelBufferByteInput(buf);
        try {
            unmarshaller.start(input);
            Object obj = unmarshaller.readObject();
            unmarshaller.finish();
            in.readerIndex(in.readerIndex() + objectSize);
            return obj;
        } finally {
            unmarshaller.close();
        }
    }
}
