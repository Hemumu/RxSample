package com.helin.rxsample.enity;

/**
 * Created by helin on 2016/11/10 17:10.
 */

public class UserEntity {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;
    private int age;
}
