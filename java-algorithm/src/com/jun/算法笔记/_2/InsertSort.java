package com.jun.算法笔记._2;

/**
 * @author Jun
 * @date 2020/7/13 下午1:15
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {100, 3, 5, 6, 1, 3, 56};

        sort(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();
    }

    public static void sort(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            // j > 0 , can't equal 不能取等
            for (int j = i; j > 0; j--) {
                // 这里决定 插入排序的 性能
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                } else {
                    break;
                }
            }
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
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1]))
                    exch(a, j, j - 1);
                else break;
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
