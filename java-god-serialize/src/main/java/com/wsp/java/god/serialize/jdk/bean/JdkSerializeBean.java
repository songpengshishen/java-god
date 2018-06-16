package com.wsp.java.god.serialize.jdk.bean;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * JDK序列化示例使用的bean
 * @author wsp
 * Date : 2018/06/16
 */
public class JdkSerializeBean implements Serializable {

    private String s1 = "s1";
    private int i1 = 1;
    private Long l1 = 10l;
    private Double d1 = 100.00;
    private Boolean b1 = false;
    private byte bb1 = (byte)0xab;



    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(this.s1);
        out.writeInt(i1);
        out.writeLong(this.l1);
        out.writeDouble(d1);
        out.writeBoolean(b1);
        out.writeByte(bb1);
    }

    private void readObject(ObjectInputStream in) throws
            ClassNotFoundException, IOException {
        s1 =   (String)in.readObject();
        i1 =   in.readInt();
        l1 =   in.readLong();
        d1 =   in.readDouble();
        b1 =   in.readBoolean();
        bb1 =  in.readByte();
    }

    @Override
    public String toString() {
        return "JdkSerializeBean{" +
                "s1='" + s1 + '\'' +
                ", i1=" + i1 +
                ", l1=" + l1 +
                ", d1=" + d1 +
                ", b1=" + b1 +
                ", bb1=" + bb1 +
                '}';
    }
}
