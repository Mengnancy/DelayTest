package com.qm.nettylearn.msgpack;

import org.msgpack.annotation.Message;

import java.io.Serializable;

/**
 * @Author: Linglingxin
 * @Date: 2018/11/28 22:30
 */
@Message
public class UserInfo {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
