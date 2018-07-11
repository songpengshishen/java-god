package com.wsp.java.god.designpattern.adapter.objects;

/**
 * 对象适配器测试
 * @author wsp
 */
public class Main {

    public static void main(String[] args) {
        Ps2 p1 = new Ps2Adapter(new Usb3());
        p1.usePs2();
    }
}
