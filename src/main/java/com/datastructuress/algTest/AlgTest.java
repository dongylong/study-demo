package com.datastructuress.algTest;

import com.datastructuress.alg.AlgDemo;
import org.junit.Test;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author dongyl
 * @date 14:29 11/20/17
 * @project study-demo
 */
public class AlgTest {
    private int[] a = new int[]{6, 3, 7, 9, 4, 8, 2, 5, 1};
    private int n = a.length - 1;


    @Test
    public void floorTest() {
        int i = 7;
        boolean flag = true;
        while (flag) {
            if (i % 2 == 1) {
                if (i % 3 == 2) {
                    if (i % 5 == 4) {
                        if (i % 6 == 5) {
                            System.out.println("i:" + i);
                            flag = false;
                        }
                    }
                }
            }
            i += 7;
        }
    }

    @Test
    public void primeNumber() {
        for (int i = 4; i < 2001; i += 2) {
            for (int n = 2; n < i/2; n++) {
                if (prime(n)) {
                    if (prime(i - n)) {
                        System.out.println("i: " + i + " n: " + n + " + " + (i - n));
                        break;
                    }
                }
            }
        }
    }
    private boolean prime(int i) {
        if (i <=1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void QuickSortTest() {
        AlgDemo algDemo = new AlgDemo();
        algDemo.quickSort(0, n, a);
    }

//    @After
//    public void print() {
//        for (int i = 0; i <= n; i++) {
//            System.out.println(a[i]);
//        }
//    }

    @Test
    public void blockQueue() {
        Queue queue = new ArrayBlockingQueue(20);

        int[] qq = new int[]{0, 6, 3, 1, 7, 5, 8, 9, 2, 4};
//        List<Integer> q = new ArrayList<>();
        for (int i = 0; i < qq.length; i++) {
            queue.add(qq[i]);
        }
        int head = 0;
        int tail = 9;
        while (head < tail) {
            System.out.println(queue.element());
            head++;
            tail++;
            queue.add(queue.element());
            head++;
        }
        System.out.println(queue);
    }
//    @Test
//    public void QuickSortTestBak() {
//        int[] a = new int[]{6, 3, 7, 9, 4, 8, 2, 5, 1};
//        int i = 1;
//        int j = a.length - 1;
//        int tmp = a[0];
//
//        while (i < j) {
//            if (a[j] > tmp) {
//                j--;
//                continue;
//            }
//            if (a[i] < tmp) {
//                i++;
//                continue;
//            }
//            int chg = a[j];
//            a[j] = a[i];
//            a[i] = chg;
//        }
//        int chg = a[j];
//        a[j] = a[0];
//        a[0] = chg;
//        quickSort(0,j-1);
//        quickSort(j+1,a.length-1);
//    }
}
