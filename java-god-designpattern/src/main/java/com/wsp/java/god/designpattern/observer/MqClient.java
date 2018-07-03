package com.wsp.java.god.designpattern.observer;

/**
 * Mq客户端
 */
public class MqClient implements Observer {

    private String name;

    public MqClient(String name) {
        this.name = name;
    }

    @Override
    public void updateMessage(String msg) {
        System.out.println("接受到的消息 : " + name + msg);
    }
}
