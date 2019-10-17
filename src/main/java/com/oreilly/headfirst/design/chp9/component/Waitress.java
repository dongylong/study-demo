package com.oreilly.headfirst.design.chp9.component;

import com.oreilly.headfirst.design.chp9.iterator.DinnerMenu;
import com.oreilly.headfirst.design.chp9.iterator.MenuItem;
import com.oreilly.headfirst.design.chp9.iterator.PancakeHouseMenu;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/17 09:16
 * @changeRecord
 */
public class Waitress {

    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    void printMenu() {
        allMenus.print();

    }
}
