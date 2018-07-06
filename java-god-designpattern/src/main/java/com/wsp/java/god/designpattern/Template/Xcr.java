package com.wsp.java.god.designpattern.template;

/**
 * 小炒肉
 * @author wsp
 */
public class Xcr extends AbstractCookTemplate{

    @Override
    protected void preparation() {
        System.out.println("准备肉,辣椒");
    }

    @Override
    protected void doing() {
        System.out.println("炒小炒肉");
    }

    @Override
    protected void serving() {
        System.out.println("出锅小炒肉");
    }
}
