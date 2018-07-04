package com.wsp.java.god.ioc.guice.demo2;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * 一个客户端
 * @author wsp
 */
public class Client {
    public static void main(String[] args) {
       Injector injector =  Guice.createInjector(new HelloModule());
       IHello iHello =    injector.getInstance(IHello.class);
       iHello.sayHello();
    }
}
