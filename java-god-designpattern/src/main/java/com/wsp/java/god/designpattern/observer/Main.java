package com.wsp.java.god.designpattern.observer;

/**
 * 测试
 */
public class Main {

    public static void main(String[] args) {
           MqSubject mqSubject = new MqSubject();
           mqSubject.registerObserver(new MqClient("a"));
           mqSubject.registerObserver(new MqClient("b"));
           mqSubject.registerObserver(new MqClient("c"));
           mqSubject.notifyObserver();
    }

}
