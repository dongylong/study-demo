package com.oreilly.headfirst.design.chp9;

import java.util.ArrayList;
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
public class Waitress {

    void printMenu() {
        printBreakfastMenu();
        printLunchMenu();

    }
    void printBreakfastMenuIterator() {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        ArrayList breakfastItem = pancakeHouseMenu.getMenuItems();
        Iterator iterator = breakfastItem.iterator();
        while (iterator.hasNext()){
            MenuItem menuItem = (MenuItem) iterator.next();
        }
    }
    void printLunchMenuIterator() {
        DinnerMenu dinnerMenu = new DinnerMenu();
        MenuItem[] lunchItems = dinnerMenu.getMenuItems();
    }

    void printBreakfastMenu() {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        ArrayList breakfastItem = pancakeHouseMenu.getMenuItems();
        int breakfastItemSize = breakfastItem.size();

        for (int i = 0; i < breakfastItemSize; i++) {
            MenuItem menuItem = (MenuItem) breakfastItem.get(i);
            System.out.println(menuItem.getName() + " ");
            System.out.println(menuItem.getPrice() + " ");
            System.out.println(menuItem.getDescription() + " ");
        }
    }

    void printLunchMenu() {
        DinnerMenu dinnerMenu = new DinnerMenu();
        MenuItem[] lunchItems = dinnerMenu.getMenuItems();
        int lunchItemSize = lunchItems.length;
        for (int i = 0; i < lunchItemSize; i++) {
            MenuItem lunchItem = lunchItems[i];
            System.out.println(lunchItem.getName() + " ");
            System.out.println(lunchItem.getPrice() + " ");
            System.out.println(lunchItem.getDescription() + " ");
        }
    }
    void printVegetarianMenu() {

    }
    boolean isItemVegetarian(String name) {
        return false;
    }
}
