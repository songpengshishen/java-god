package com.wsp.java.god.ioc.guice.demo2;

import com.google.inject.Singleton;

/**
 * MyHello
 * @author wsp
 */
@Singleton
public class MyHello implements IHello {

    @Override
    public void sayHello() {
        System.out.println("say My Hello!");
    }
}
