package com.jun.算法笔记._2;

/**
 * @author Jun
 * @date 2020/7/15 上午10:16
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//        int[] nums = {0, 1, 2, 3, 4};
        sort(nums, 0, nums.length - 1);
        print(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int start, int end) {
        if (start < end) {
            int lo = start;
            int hi = end;
            int num = nums[start];
            while (lo != hi) {
                while (lo < hi && nums[hi] <= num) hi--;
                swap(nums, lo, hi);
                while (lo < hi && nums[lo] >= num) lo++;
                swap(nums, lo, hi);
            }
            sort(nums, start, lo - 1);
            sort(nums, lo + 1, end);
        }
    }

    private static void swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }


    private static void print(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();
    }
}
