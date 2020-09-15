package com.jun.算法笔记._2._3sort;

/**
 * @author: Jun
 * @date: 2020/7/14 12:27
 */
public class MergeSort {
    private static int[] aux;

    public static void main(String[] args) {
        int[] nums = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//        int[] nums = {0, 1, 2, 3, 4};
        aux = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        print(nums, 0, nums.length - 1);
    }

    private static void print(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();
    }

    private static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();
    }

    public static void sort(int[] nums, int start, int end) {
        System.out.printf("sort(int[] nums, int %d, int %d)\n", start, end);
        print(nums, start, end);

        if (start < end) {
            int mid = start + (end - start) / 2;
            sort(nums, start, mid);
            sort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    public static void merge(int[] nums, int start, int mid, int end) {
        System.out.printf("\tmerge(int[] nums, int %d, int %d, int %d)\n", start, mid, end);
        print(nums, start, end);
        int left = start;
        int right = mid + 1;

        for (int i = start; i <= end; i++) {
            aux[i] = nums[i];
        }


        /*
            归并排序：
                一个数组 每次从中间 分成两个部分，依次递归分解下去，从而保证每个数组长度是 1，
                主要是 归，两个数组 按照想要的次序开始合并成 有序数组，从小规模到大规模，直到排序完成
                看成两个数组
                第一个数组 [left, mid]
                第二个数组 [mid + 1, right]
            arr [E  E   G   M   R   A   C   E   R   T]
                 i
            aux [E  E   G   M   R   A   C   E   R   T]
                 l              m   m+1             r
        */

        for (int i = start; i <= end; i++) {
            // left > mid 左边数组用完
            if (left > mid) {
                nums[i] = aux[right++];
                continue;
            }
            // right > end 右边数组用完
            if (right > end) {
                nums[i] = aux[left++];
                continue;
            }
            // 根据这里的 不等号 决定 升序 还是降序
            if (aux[right] < aux[left]) {
                nums[i] = aux[right++];
            } else {
                nums[i] = aux[left++];
            }
        }
    }

}
