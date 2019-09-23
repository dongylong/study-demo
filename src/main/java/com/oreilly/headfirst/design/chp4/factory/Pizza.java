package com.oreilly.headfirst.design.chp4.factory;

import com.oreilly.headfirst.design.chp4.bean.*;

import java.util.ArrayList;

/**
 * @AUTHOR liuling
 * @DATE 2019/1/26 09:00
 * @PROJECT studydemo
 **/
public abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    ArrayList toppings = new ArrayList();
    Veggies[] veggies;
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;

    abstract void prepare();

    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    void cut() {
        System.out.println("cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("place pizza in official pizzastore box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{}";
    }
}
