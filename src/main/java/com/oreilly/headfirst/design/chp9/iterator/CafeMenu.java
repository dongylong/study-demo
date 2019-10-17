package com.oreilly.headfirst.design.chp9.iterator;

import java.util.Hashtable;
import java.util.Iterator;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/15 09:57
 * @changeRecord
 */
public class CafeMenu implements Menu {
    Hashtable menuItems = new Hashtable();

    public CafeMenu() {
        addItem("Vegetarian BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT", "(Fakin') Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Burrito", "alarge ", false, 3.29);
    }

    private void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.put(name,menuItem);

    }

//    public Hashtable getMenuItems() {
//        return menuItems;
//    }

    @Override
    public Iterator createIterator() {

        return menuItems.values().iterator();
    }
}
