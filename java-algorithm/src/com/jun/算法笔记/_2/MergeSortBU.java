package com.jun.算法笔记._2;

/**
 * 自底向上 归并排序
 *
 * @author Jun
 * @date 2020/7/15 上午9:46
 */
public class MergeSortBU {
    private static int[] aux;

    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//        int[] nums = {0, 1, 2, 3, 4};
        aux = new int[nums.length];
        sort(nums);
        print(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums) {
        int n = nums.length;
        for (int sz = 0; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                merge(nums, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
            }

        }
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;

        for (int i = start; i <= end; i++) {
            aux[i] = nums[i];
        }

        for (int i = start; i <= end; i++) {
            if (left > mid) {
                nums[i] = aux[right++];
            } else if (right > end) {
                nums[i] = aux[left++];
            } else if (aux[right] > aux[left]) {
                nums[i] = aux[right++];
            } else {
                nums[i] = aux[left++];
            }
        }
    }

    private static void print(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();
    }
}
