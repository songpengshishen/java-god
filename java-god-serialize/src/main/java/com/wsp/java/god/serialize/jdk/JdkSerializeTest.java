package com.wsp.java.god.serialize.jdk;

import com.wsp.java.god.serialize.jdk.bean.JdkSerializeBean;

import java.io.*;

/**
 * JDK序列化 测试类
 * @author wsp
 * Date : 2018/06/16
 */
public class JdkSerializeTest {

    public static void main(String[] args) throws Exception{
        //序列化
        long sTime = System.currentTimeMillis();
        FileOutputStream fo = new FileOutputStream(new File("D:\\b.obj"));
        ObjectOutputStream objOut = new ObjectOutputStream(fo);
        objOut.writeObject(new JdkSerializeBean());
        System.out.println("-----序列化耗时----- :  " + (System.currentTimeMillis() - sTime));

        long sTime1 = System.currentTimeMillis();
        FileInputStream fi = new FileInputStream(new File("D:\\b.obj"));
        ObjectInputStream objIn = new ObjectInputStream(fi);
        JdkSerializeBean jsb = (JdkSerializeBean)objIn.readObject();
        System.out.println("-----反序列读出的Obj----- :  " + jsb  + "\t" +"---共耗时--- : " + (System.currentTimeMillis() - sTime1));

    }



}
