package com.oreilly.headfirst.design.chp6;

import lombok.Data;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019-09-26 09:37
 * @changeRecord
 */
@Data
public class LightOffCommand implements Command {

    Light light;

    @Override
    public void execute() {
        light.off();
    }

}
