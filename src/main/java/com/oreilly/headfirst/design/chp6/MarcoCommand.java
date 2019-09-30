package com.oreilly.headfirst.design.chp6;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019-09-26 10:03
 * @changeRecord
 */
public class MarcoCommand implements Command {
    Command[] commands;

    // 用命令数组存储一大堆命令
    public MarcoCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        int len = commands.length;
        for (int i = 0; i < len; i++) {
            commands[i].execute();
        }
    }
}
