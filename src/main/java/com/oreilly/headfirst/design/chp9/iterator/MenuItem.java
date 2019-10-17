package com.oreilly.headfirst.design.chp9.iterator;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/8 09:59
 * @changeRecord
 */
@Data
@AllArgsConstructor
public class MenuItem {
    String name;
    String description;
    boolean vegetarian;
    double price;
}
