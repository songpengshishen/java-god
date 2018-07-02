package com.wsp.java.god.designpattern.singleton;

/**
 * 单例类
 * @author wsp
 */
public class Singleton {



    private Singleton(){}

    /**
     * 使用一个内部类维护单例,利用jvm加载时的唯一性和互斥行保证单例正确初始化
     */
    private static class SingletonHolder{
        private static final  Singleton instance = new Singleton();
    }


    public static Singleton getInstance(){
       return SingletonHolder.instance;
    }
}
