//package com.study.algorithms.chp2;
//
//import scala.tools.nsc.ast.parser.Insertion;
//
///**
// * @author dongyl
// * @version 1.0
// * @title
// * @description
// * @company 好未来-爱智康
// * @created 2019-07-17 09:44
// * @changeRecord
// */
//public class Quick {
//    private static final int M = 15;//5-15
//    public static void sort(Comparable[] a) {
//        StdRandom.shuffle(a);
//        sort(a, 0, a.length - 1);
//    }
//
//    private static void sort(Comparable[] a, int lo, int hi) {
////        if (hi < lo) {
////            return;
////        }
//        if (hi <= lo + M) {
//            Insertion.sort(a,lo,hi);
//            return;
//        }
//        int j = partition(a, lo, hi);
//        sort(a, lo, j - 1);
//        sort(a, j + 1, hi);
//    }
//
//    private static int partition(Comparable[] a, int lo, int hi) {
//        //左右指针
//        int i = lo;
//        int j = hi + 1;
//        //切分元素
//        Comparable v = a[lo];
//        while (true) {
//            while (less(a[++i], v)) {
//                if (i == hi) {
//                    break;
//                }
//            }
//            while (less(v, a[--j])) {
//                if (j == lo) {
//                    break;
//                }
//            }
//            if (i >= j) {
//                break;
//            }
//            exch(a, i, j);
//        }
//        //将v =a[j]放入到正确的位置
//        exch(a, lo, j);
//        // a[lo..j-1]<=a[j]<=a[j+1..hi]达成
//        return j;
//    }
//
//    private static void exch(Comparable[] a, int i, int j) {
//    }
//
//    private static boolean less(Comparable comparable, Comparable v) {
//        return true;
//    }
//}
