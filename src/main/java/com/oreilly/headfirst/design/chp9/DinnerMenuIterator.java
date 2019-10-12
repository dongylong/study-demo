package com.oreilly.headfirst.design.chp9;


import java.util.Iterator;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019/10/10 09:52
 * @changeRecord
 */
public class DinnerMenuIterator implements Iterator {
    MenuItem[] menuItems;
    int position = 0;

    public DinnerMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        if (position >= menuItems.length || menuItems[position] == null) {
            return false;
        }
        return true;
    }
    @Override
    public void remove(){
        if(position<1){
            return;
        }
        if(menuItems[position-1] !=null){
            for (int i = position-1 ; i < menuItems.length-1; i++) {
                menuItems[i] = menuItems[i+1];
            }
            menuItems[menuItems.length-1] = null;
        }

    }
}
