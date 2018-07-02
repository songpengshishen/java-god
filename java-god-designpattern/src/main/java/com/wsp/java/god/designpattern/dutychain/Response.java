package com.wsp.java.god.designpattern.dutychain;

/**
 * 响应对象
 * @author wsp
 */
public class Response {

    private String res;

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    @Override
    public String toString() {
        return "Response{" +
                "res='" + res + '\'' +
                '}';
    }
}
