package com.qm.classload;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoadDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader cl = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".")) + ".class";

                InputStream ins = getClass().getResourceAsStream(fileName);

                if (ins == null) {
                    return super.loadClass(name);
                }

                try {
                    byte[] buff = new byte[ins.available()];
                    ins.read(buff);

                    return defineClass(name, buff, 0, buff.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };

        Object c = cl.loadClass("com.qm.classload.ClassLoadDemo").newInstance();

        System.out.println();

        System.out.println(c instanceof ClassLoadDemo);
    }
}
