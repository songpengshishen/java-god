package com.wsp.java.god.designpattern.factory.abstractfactory;

/**
 * Created by wangsongpeng on 2018/6/30.
 */
public class Main {
    public static void main(String[] args) {
        PcFactory xm = new XiaomiPcFactory();
        xm.createMouse();
        xm.createKeyBoard();
        PcFactory hw = new HuaweiPcFactory();
        hw.createKeyBoard();
        hw.createMouse();
    }
}
