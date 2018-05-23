package com.datastructuress;

import org.apache.commons.lang.ArrayUtils;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author dongyl
 * @date 18:37 5/7/18
 * @project study-demo
 */
public class Array {
    private void arrayIsNull() {
        int[] a = new int[5];
        System.out.println(ArrayUtils.isEmpty(a) +"...... isEmpty");
        System.out.println(a == null ? 0 : 1);
    }

    public static void main(String[] args) {
        int[] a = null;
        System.out.println(ArrayUtils.isEmpty(a) +"...... isEmpty");
        System.out.println(a == null ? 0 : 1);
    }
    private void copyOnWriteArrayListDemo(){
        List<Integer> array = new CopyOnWriteArrayList<>();
        CopyOnWriteArraySet<Object> set = new CopyOnWriteArraySet<>();
    }
}
