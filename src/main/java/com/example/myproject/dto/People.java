package com.example.myproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Arrays;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class People {
    String account;
    String birth;
    int age;
    Friend[] friends;

    public People() {
    }

    public People(String account, int age) {
        this.account = account;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "account='" + account + '\'' +
                ", birth='" + birth + '\'' +
                ", age=" + age +
                ", friends=" + Arrays.toString(friends) +
                '}';
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Friend[] getFriends() {
        return friends;
    }

    public void setFriends(Friend[] friends) {
        this.friends = friends;
    }
}
