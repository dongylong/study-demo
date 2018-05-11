package com.datastructuress;

import org.apache.commons.lang.ArrayUtils;

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
}
