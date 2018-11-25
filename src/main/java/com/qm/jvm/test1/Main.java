package com.qm.jvm.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Linglingxin
 * @Date: 2018/9/18 23:54
 */
public class Main {
    public static void main(String[] args) {
        List<Demo> list = new ArrayList<>();
        while (true) {
            list.add(new Demo());
        }
    }
}
