package com.wsp.java.god.serialize.mp;


import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.msgpack.MessagePack;
import org.msgpack.template.Templates;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * 简单的msgpack示例
 * Create Date : 2018-6-11
 * @author wsp
 */
public class SimpleMpDemo {

    public static void main(String[] args)throws Exception {
        MessagePack msgpack = new MessagePack();
        List<String> ls = Arrays.asList("java","c++",".net","python","c");
        byte[] result =  msgpack.write(ls);


        ByteOutputStream byteOut =  new ByteOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(byteOut);
        objOut.writeObject(ls);
        System.out.println("result jdk byte num is : " + byteOut.size());
        System.out.println("result mp byte num is : " + result.length);
        List<String> ls2 =  msgpack.read(result, Templates.tList(Templates.TString));
        System.out.println(ls2);


    }

}
