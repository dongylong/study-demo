package com.oreilly.headfirst.design.chp9.component;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/10 09:16
 * @changeRecord
 */
public class MenuTestDriver {
    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "BREAKFAST");
        MenuComponent dinnerMenu = new Menu("DINNER MENU", "LUNCH");
        MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
        MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinnerMenu);
        allMenus.add(cafeMenu);
        dinnerMenu.add(new MenuItem(
                "Pasta",
                "Spagetti",
                true,
                3.89
        ));
        dessertMenu.add(new MenuItem(
                "Aple Pie",
                "Apple pie with a flakey crust.",
                true,
                1.59
        ));
        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();
    }
}
