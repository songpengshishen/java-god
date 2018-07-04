package com.wsp.java.god.designpattern.Template;

/**
 * 宫爆鸡丁
 * @author wsp
 */
public class Gbjd extends AbstractCookTemplate {

    @Override
    protected void preparation() {
        System.out.println("准备鸡肉,葱花");
    }

    @Override
    protected void doing() {
        System.out.println("炒宫爆鸡丁");
    }

    @Override
    protected void serving() {
        System.out.println("出宫爆鸡丁");
    }
}
