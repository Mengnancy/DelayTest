package com.qm.nettylearn.marshalling;

import java.io.Serializable;

/**
 * @Author: Linglingxin
 * @Date: 2018/11/28 22:30
 */
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 4923081103118853877L;
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

    @Override
    public String toString() {
        return "UserInfo{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
