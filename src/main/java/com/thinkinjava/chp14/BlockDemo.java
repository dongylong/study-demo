package com.thinkinjava.chp14;

/**
 * @author dongyl
 * @date 09:29 10/19/18
 * @project study-demo
 */
public class BlockDemo {
    public static void main(String[] args) {
        Object wn2 = 0;
        synchronized(wn2){
            wn2.notify();
        }
    }

}
