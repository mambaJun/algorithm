package com.jun.算法笔记._2._3sort;

public class SelectSort {


    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6, 1, 3, 56};

        sort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 把当前节点 看作最小 ，然后遍历 [i + 1, n), 记录最小值， 然后 将 arr[i]  arr[min] 交换
            int min = i;
            for (int j = i + 1; j < n; j++) {
                min = arr[j] < arr[min] ? j : min;
            }
            // 交换
            swap(arr, i, min);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /*----------------------- 参考 -----------------------*/

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[i], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
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