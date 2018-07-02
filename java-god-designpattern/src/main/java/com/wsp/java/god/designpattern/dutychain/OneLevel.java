package com.wsp.java.god.designpattern.dutychain;

/**
 * 一级职责链
 * @author wsp
 */
public class OneLevel extends AbstractLevel {

    public OneLevel(String name) {
        super(name);
    }

    @Override
    public Response handler(Request req) {
        System.out.println(" level Name :  " + this.getName() + req.getReq());
        return getNextLevel().handler(req);
    }
}
