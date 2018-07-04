package com.wsp.java.god.designpattern.Template;

/**
 * 模板模式测试类
 * @author wsp
 */
public class Main {

    public static void main(String[] args) {
        AbstractCookTemplate gbjd = new Gbjd();
        gbjd.cook();

        System.out.println("--------------------------------");

        AbstractCookTemplate xcr = new Xcr();
        xcr.cook();
    }
}
