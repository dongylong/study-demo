package com.datastructuress.alg;

/**
 * @author dongyl
 * @date 11:24 11/14/17
 * @project study-demo
 */
public class AlgDemo {

//    private int[] a = new int[]{6, 3, 7, 9, 4, 8, 2, 5, 1};
//    private int n = a.length - 1;

    public void quickSort(int left, int right, int[] a) {
        if (left >= right) {
            return;
        }
        int i = left + 1;
        int j = right;
        int tmp = a[left];

        while (i != j) {
            if (a[j] >= tmp && i < j) {
                j--;
            }
            if (a[i] <= tmp && i < j) {
                i++;
            }
            if (i < j) {
                int chg = a[i];
                a[i] = a[j];
                a[j] = chg;
            }
        }
        if (a[i] < a[left]) {
            a[left] = a[i];
            a[i] = tmp;
        }
        quickSort(left, i - 1, a);
        quickSort(i, right, a);
    }


    public void queue() {

    }
}
