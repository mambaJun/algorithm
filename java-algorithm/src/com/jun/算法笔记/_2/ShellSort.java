package com.jun.算法笔记._2;

/**
 * @author: Jun
 * @date: 2020/7/13 20:10
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 7, 3, 2};
        sort(nums);
        print(nums);
    }

    private static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();
    }

    /*
        希尔排序 是 插入排序的增强版
        利用 h ,使用 数组有更多的 顺序 子序列，从而提高速度
    */
    private static void sort(int[] nums) {
        int n = nums.length;

        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            System.out.println(h);
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && nums[j] < nums[j - h]; j -= h) {
                    swap(nums, j, j - h);
                }

            }

            h /= 3;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
