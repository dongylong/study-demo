package com.study.posts.telecompress.chp2.exercise;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019-06-04 11:40
 * @changeRecord
 */
public class Exercise {

    /**
     * 习题 2.1
     * 三
     * 10
     */
    private void deleteItem(int[] a, int item) {
        int k = 0;
        int len = a.length;
        for (int i = 0; i < len; i++) {
            if (a[i] != item) {
                a[k] = a[i];
                k ++;
            }
        }
        for (int i = k; i < len; i++) {
            a[i] = 0;
        }
    }
}
