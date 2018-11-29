package com.qm.nettylearn.marshalling;

import io.netty.handler.codec.marshalling.*;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

/**
 * @Author: Linglingxin
 * @Date: 2018/11/29 23:55
 */
public class MarshallingCodeFactory {
    public static MarshallingDecoder buildMarshallingDecoder() {

        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);

        UnmarshallerProvider provider = new DefaultUnmarshallerProvider(marshallerFactory, configuration);
        return new MarshallingDecoder(provider,1024);
    }

    public static MarshallingEncoder buildMarshallingEncoder() {

        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
        final MarshallingConfiguration configuration = new MarshallingConfiguration();
        configuration.setVersion(5);

        MarshallerProvider provider = new DefaultMarshallerProvider(marshallerFactory, configuration);
        return new MarshallingEncoder(provider);
    }
}
