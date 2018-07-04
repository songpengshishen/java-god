package com.wsp.java.god.designpattern.Template;

/**
 * 模板模式的做饭抽象类
 * @author wsp
 */
public abstract class AbstractCookTemplate {


    public void cook(){
       preparation();
       doing();
       serving();
    }

    /**
     * 备菜
     */
    protected abstract void preparation();

    /**
     * 开始做
     */
    protected abstract void doing();

    /**
     * 上菜
     */
    protected abstract void serving();
}
