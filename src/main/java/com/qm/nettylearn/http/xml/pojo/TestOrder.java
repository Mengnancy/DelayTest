package com.qm.nettylearn.http.xml.pojo;

import org.jibx.runtime.*;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @Author: Linglingxin
 * @Date: 2018/12/2 20:49
 */
public class TestOrder {
    private IBindingFactory factory = null;
    private StringWriter writer = null;
    private StringReader reader = null;
    private final static String CHARSET_NAME = "UTF-8";

    private String encode2xml(Order order) throws JiBXException, IOException {
        factory = BindingDirectory.getFactory(Order.class);
        writer = new StringWriter();
        IMarshallingContext context = factory.createMarshallingContext();
        context.setIndent(2);
        context.marshalDocument(order, CHARSET_NAME, null, writer);
        String xmlstr = writer.toString();
        writer.close();
        System.out.println(xmlstr);
        return xmlstr;
    }

    private Order decode2Order(String xmlBody) throws JiBXException {
        reader = new StringReader(xmlBody);
        IUnmarshallingContext context = factory.createUnmarshallingContext();
        Order order = (Order) context.unmarshalDocument(reader);
        return order;
    }

    public static void main(String[] args) throws JiBXException, IOException {
        TestOrder testOrder = new TestOrder();
        Order order = OrderFactory.create(123);
        String body = testOrder.encode2xml(order);
        Order order1 = testOrder.decode2Order(body);
        System.out.println(order1);
    }

}
