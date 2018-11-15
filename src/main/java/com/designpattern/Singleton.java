package com.designpattern;

/**
 * @author dongyl
 * @date 11:28 11/5/18
 * @project study-demo
 */
public class Singleton {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public Singleton() {
    }
    public Singleton getSingleton() {
        return SingletonHolder.INSTANCE;
    }
}
