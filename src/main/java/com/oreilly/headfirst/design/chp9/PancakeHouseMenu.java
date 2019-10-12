package com.oreilly.headfirst.design.chp9;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/8 09:43
 * @changeRecord
 */
public class PancakeHouseMenu {
    ArrayList menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList();
        addItem("K&B's pancake breakfast", "11", true, 2.99);
        addItem("regular pancake breakfast", "22", false, 2.99);
        addItem("blueberry pancakes", "3", true, 3.49);
        addItem("waffles", "4", true, 3.59);
    }

    private void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public ArrayList getMenuItems() {
        return menuItems;
    }


    public Iterator createIterator() {
        return new PancakeHouseMenuIterator(menuItems);
    }
}
