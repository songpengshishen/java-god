package com.wsp.java.god.designpattern.factory.abstractfactory;

/**
 * 华为键盘
 */
public class HuaweiKeyBoard implements KeyBoard {
    @Override
    public void typing() {
        System.out.println("华为打字");
    }
}
