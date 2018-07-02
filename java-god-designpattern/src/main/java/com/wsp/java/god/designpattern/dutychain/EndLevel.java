package com.wsp.java.god.designpattern.dutychain;

/**
 * 最后一级职责链
 * @author
 */
public class EndLevel extends AbstractLevel {

    public EndLevel(String name) {
        super(name);
    }

    @Override
    public Response handler(Request req) {
        System.out.println(" level Name :  " + this.getName() + req.getReq());
        Response res = new Response();
        res.setRes("end!");
        return res;
    }
}
