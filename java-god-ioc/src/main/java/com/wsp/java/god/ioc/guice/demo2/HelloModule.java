package com.wsp.java.god.ioc.guice.demo2;

import com.google.inject.AbstractModule;

/**
 * Hello装配模型
 * @author wsp
 */
public class HelloModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(IHello.class).to(MyHello.class);
    }
}
