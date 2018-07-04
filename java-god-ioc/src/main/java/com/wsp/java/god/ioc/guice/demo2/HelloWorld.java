package com.wsp.java.god.ioc.guice.demo2;

import com.google.inject.Singleton;

/**
 * Hello World
 * @author wsp
 */
@Singleton
public class HelloWorld implements IHello{

    @Override
    public void sayHello() {
        System.out.println("say Hello Wrold!");
    }
}
