package com.jun.算法笔记._2._3sort;

/**
 * @author: Jun
 * @date: 2020/7/14 22:50
 */
public class MergeSort_1 {

    public static void main(String[] args) {
        int[] nums = {0, 4, 1, 5, 6, 2, 3, 8};

        sort(nums, 0, nums.length - 1);
        print(nums, 0, nums.length - 1);
    }

    private static void print(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();
    }

    private static void sort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            sort(nums, start, mid);
            sort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        // 左数组的起点
        int left = start;
        // 右数组的起点
        int right = mid + 1;

        int[] tmp = new int[end - start + 1];
        for (int i = 0; i <= end - start; i++) {
            tmp[i] = nums[start + i];
        }

        for (int i = start; i <= end; i++) {
            if (left > mid) {
                nums[i] = tmp[right++];
                continue;
            }
            if (right > end) {
                nums[i] = tmp[left++];
                continue;
            }
            if (tmp[left] > tmp[right]) {
                nums[i] = tmp[left++];
            } else {
                nums[i] = tmp[right++];
            }
        }
    }
}
