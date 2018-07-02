package com.wsp.java.god.designpattern.dutychain;

/**
 * 职责中级别接口
 * @author wsp
 */
public interface Level {


    Response handler(Request req);

}
