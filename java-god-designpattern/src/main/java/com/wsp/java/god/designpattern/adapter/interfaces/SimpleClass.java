package com.wsp.java.god.designpattern.adapter.interfaces;

/**
 * 简单的类实现适配器只完成基本的功能
 * @author wsp
 */
public class SimpleClass extends ComplexInterfaceAdapter{

    @Override
    public void a() {
        System.out.println("我只实现A");
    }


    @Override
    public void e() {
        System.out.println("我只实现E");
    }
}
