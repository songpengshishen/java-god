package com.wsp.java.god.designpattern.command;

/**
 * 命令模式的命令接口实现
 * @author wsp
 */
public class CommandImpl implements Command {

    private Receiver receiver;

    public CommandImpl(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
