package com.qm.hot;

import java.io.*;

public class RunTest {
    public static void main(String[] args) throws IOException {
        InputStream in = new RunTest().getClass().getResourceAsStream("Test.class");
        byte[] classBytes = new byte[1024];
        int haveRead = 0;
        haveRead = in.read(classBytes);
        byte[] newbytes = new byte[haveRead];
        System.arraycopy(classBytes, 0, newbytes, 0, haveRead);
        System.out.println(haveRead);
        System.out.println(JavaClassExecutor.execute(newbytes));
    }
}
