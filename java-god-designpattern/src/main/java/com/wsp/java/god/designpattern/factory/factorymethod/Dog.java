package com.wsp.java.god.designpattern.factory.factorymethod;

/**
 * 小狗实现动物接口
 */
public class Dog implements Animal {

    @Override
    public void action() {
        System.out.println("汪汪叫");
    }
}
