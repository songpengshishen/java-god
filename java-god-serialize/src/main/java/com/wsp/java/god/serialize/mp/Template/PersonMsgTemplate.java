package com.wsp.java.god.serialize.mp.Template;

import com.wsp.java.god.serialize.mp.bean.Person;
import org.msgpack.packer.Packer;
import org.msgpack.template.AbstractTemplate;
import org.msgpack.unpacker.Unpacker;

import java.io.IOException;

/**
 * msg 模板扩展类
 * @author wsp
 * Create Date : 2018/06/12
 */
public class PersonMsgTemplate extends AbstractTemplate<Person>{


    @Override
    public void write(Packer packer, Person person, boolean b) throws IOException {
         if(null == person){
             packer.writeNil();
         }else{
             //这里不能使用write(Object o),否则会触发再次从模板注册中拿取模板进行编码
             packer.write(person.getName());
             packer.write(person.getAge());
             packer.write(person.getMoney());
         }
    }

    @Override
    public Person read(Unpacker unpacker, Person person, boolean b) throws IOException {
        if(null == person){
            person = new Person();
            person = new Person();
        }
        int age =  unpacker.readInt();
        person.setAge(age);
        String name =  unpacker.readString();
        person.setName(name);
        double money =  unpacker.readDouble();
        person.setMoney(money);
        return person;
    }
}
