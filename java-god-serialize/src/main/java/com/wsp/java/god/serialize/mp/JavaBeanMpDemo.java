package com.wsp.java.god.serialize.mp;

import com.wsp.java.god.serialize.mp.bean.Person;
import com.wsp.java.god.serialize.mp.bean.PersonClone;
import com.wsp.java.god.serialize.mp.bean.PersonFieldOrderError;
import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

/**
 * java Bean msgpack示例
 * Create Date : 2018-6-11
 * @author wsp
 */
public class JavaBeanMpDemo {

    public static void main(String[] args)throws Exception {
        MessagePack msg = new MessagePack();
        msg.register(Person.class);
        msg.register(PersonClone.class);
        msg.register(PersonFieldOrderError.class);
        Person p = new Person("wsp",12,30.35);
        byte[] result =  msg.write(p);
        PersonFieldOrderError pc = msg.read(result, PersonFieldOrderError.class);
        System.out.println("反序列化后 person = " + pc);
    }

}
