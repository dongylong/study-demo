package com.oreilly.headfirst.design.chp9.iterator;

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
public class WaitressIterator {

    Menu pancakeHouseMenu;
    Menu dinnerMenu;
    Menu cafeMenu;

//    PancakeHouseMenu pancakeHouseMenu;
//    DinnerMenu dinnerMenu;
//
//    public WaitressIterator(PancakeHouseMenu pancakeHouseMenu, DinnerMenu dinnerMenu) {
//        this.pancakeHouseMenu = pancakeHouseMenu;
//        this.dinnerMenu = dinnerMenu;
//    }
    //改成接口 针对接口编程 而不是具体实现类
    public WaitressIterator(Menu pancakeHouseMenu, Menu dinnerMenu, Menu
            cafeMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinnerMenu = dinnerMenu;
        this.cafeMenu = cafeMenu;
    }


    void printMenu() {
        printBreakfastMenuIterator();
        printLunchMenuIterator();
        printCafeMenuIterator();

    }
    void printBreakfastMenuIterator() {
        Iterator pancakeHouseMenuIterator = pancakeHouseMenu.createIterator();
        System.out.println("----pancakeHouse-----");
        printMenu(pancakeHouseMenuIterator);
    }
    void printCafeMenuIterator() {
        Iterator cafeMenuIterator = cafeMenu.createIterator();
        System.out.println("----cafeMenuIterator-----");
        printMenu(cafeMenuIterator);
    }
    void printLunchMenuIterator() {
        Iterator dinnerMenuIterator= dinnerMenu.createIterator();
        System.out.println("----dinnerMenu-----");
        printMenu(dinnerMenuIterator);
    }
    private void printMenu(Iterator iterator){
        while (iterator.hasNext()){
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName() + ",");
            System.out.println(menuItem.getPrice() + "--");
            System.out.println(menuItem.getDescription() + " ");
        }
    }
}
