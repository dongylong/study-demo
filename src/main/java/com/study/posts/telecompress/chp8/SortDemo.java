package com.study.posts.telecompress.chp8;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2019-05-22 16:50
 * @changeRecord
 */
public class SortDemo {
    private void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pivotLoc = partition(a, low, high);
            quickSort(a, low, pivotLoc - 1);
            quickSort(a, pivotLoc + 1, high);
        }
    }

    /**
     * quickSort
     *
     * @param a
     * @param low
     * @param high
     * @return
     */
    private int partition(int[] a, int low, int high) {
        a[0] = a[low];
        int pivotKey = a[low];
        while (low < high) {
            while (low < high && a[high] >= pivotKey) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= pivotKey) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = a[0];
        return low;
    }
}
