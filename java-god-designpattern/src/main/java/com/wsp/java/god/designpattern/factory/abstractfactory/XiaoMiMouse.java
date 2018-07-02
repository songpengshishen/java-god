package com.wsp.java.god.designpattern.factory.abstractfactory;

/**
 * 小米鼠标
 */
public class XiaoMiMouse implements Mouse {

    @Override
    public void move() {
        System.out.println("小米在移动");
    }
}
