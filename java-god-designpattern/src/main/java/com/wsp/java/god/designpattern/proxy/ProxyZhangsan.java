package com.wsp.java.god.designpattern.proxy;

/**
 * 代理张三
 * @author wsp
 */
public class ProxyZhangsan implements Person{

    private Person person = new ZhangSan();

    @Override
    public void negotiation() {
        System.out.println("我代替张三来谈判");
    }
}
