package com.jun.a_常用算法.排序;

/**
 * @author Jun
 * @date 2020/7/13 下午3:58
 */
public class ShellSort {
    public static void sort(Comparable[] a) {
        int n = a.length;

        int h = 1;
        while (h < n / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
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
}
