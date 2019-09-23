package com.oreilly.headfirst.design.chp4.bean;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019-09-17 09:44
 * @changeRecord
 */

public enum PizzaTypeEnum implements IEnum {
    CHEESE("CHEESE", "CHEESE"),
    PEPPERPNI("PEPPERPNI", "PEPPERPNI"),
    CLAM("CLAM", "CLAM"),
    VEGGIE("VEGGIE", "VEGGIE"),
    ;
    String value;
    String msg;

    public static PizzaTypeEnum findByType(String type) {
        for (PizzaTypeEnum item : PizzaTypeEnum.values()) {
            if (item.value == type) {
                return item;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getMsg() {
        return msg;
    }

    PizzaTypeEnum(String value, String msg) {
        this.value = value;
        this.msg = msg;
    }
}
