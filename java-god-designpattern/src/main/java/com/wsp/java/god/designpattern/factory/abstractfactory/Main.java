package com.wsp.java.god.designpattern.factory.abstractfactory;

/**
 * 抽象工厂模式测试类
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
