package com.wsp.java.god.designpattern.adapter.objects;

/**
 * Ps2对象适配器适配Usb
 */
public class Ps2Adapter implements Ps2 {

    public Ps2Adapter(Usb usb) {
        this.usb = usb;
    }

    private Usb usb;


    @Override
    public void usePs2() {
        usb.useUsb();
    }
}
