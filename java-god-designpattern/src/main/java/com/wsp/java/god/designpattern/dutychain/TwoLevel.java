package com.wsp.java.god.designpattern.dutychain;

/**
 * 二级职责链
 * @author wsp
 */
public class TwoLevel extends AbstractLevel {

    public TwoLevel(String name) {
        super(name);
    }

    @Override
    public Response handler(Request req) {
        System.out.println(" level Name :  " + this.getName() + req.getReq());
        return getNextLevel().handler(req);
    }
}
