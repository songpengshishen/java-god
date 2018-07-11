package com.wsp.java.god.designpattern.adapter.classes;

/**
 * 类适配器测试
 * @author wsp
 */
public class Main {

    public static void main(String[] args) {
        Ps2 p1 = new Ps2Adapter();
        p1.usePs2();
    }
}
