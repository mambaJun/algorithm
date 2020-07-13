package com.jun.a_常用算法.排序;

/**
 * @author: Jun
 * @date: 2020/7/13 9:47
 */
public class 选择排序 {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[i], a[j])) {

                }
            }

        }
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {

    }
}
