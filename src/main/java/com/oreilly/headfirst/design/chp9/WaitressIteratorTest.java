package com.oreilly.headfirst.design.chp9;

import java.util.Iterator;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/10 09:16
 * @changeRecord
 */
public class WaitressIteratorTest {

    public static void main(String[] args) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinnerMenu dinnerMenu = new DinnerMenu();
        WaitressIterator waitress = new WaitressIterator(pancakeHouseMenu,dinnerMenu);
        waitress.printMenu();
    }
}
