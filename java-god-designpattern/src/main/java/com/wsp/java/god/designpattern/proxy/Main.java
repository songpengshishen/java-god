package com.wsp.java.god.designpattern.proxy;

/**
 * 代理模式测试类
 */
public class Main {

    public static void main(String[] args) {
        Person person = new ProxyZhangsan();
        person.negotiation();
    }
}
