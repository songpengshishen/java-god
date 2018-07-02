package com.wsp.java.god.designpattern.proxy;

/**
 * Created by wangsongpeng on 2018/6/30.
 */
public class Main {

    public static void main(String[] args) {
        Person person = new ProxyZhangsan();
        person.negotiation();
    }
}
