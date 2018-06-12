package com.wsp.java.god.serialize.mp;

import com.wsp.java.god.serialize.mp.Template.PersonMsgTemplate;
import com.wsp.java.god.serialize.mp.bean.Person;
import org.msgpack.MessagePack;

/**
 * 模板的msgpack示例
 * Create Date : 2018-6-12
 * @author wsp
 */
public class MpTemplateDemo {

    public static void main(String[] args)throws Exception {
        MessagePack mp = new MessagePack();
        mp.register(Person.class,new PersonMsgTemplate());
        Person p1 = new Person("张三",12,22.2);
        byte[] bytes  = mp.write(p1);
        Person p2 = mp.read(bytes,Person.class);
        System.out.println(p2);
    }
}
