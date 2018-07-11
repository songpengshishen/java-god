package com.wsp.java.god.designpattern.adapter.classes;

/**
 * Ps2类适配器适配Usb
 */
public class Ps2Adapter extends Usb3 implements Ps2{

    @Override
    public void usePs2() {
        this.useUsb();
    }
}
