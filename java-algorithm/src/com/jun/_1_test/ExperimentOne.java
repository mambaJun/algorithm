package com.jun._1_test;

/**
 * @author Jun
 * @date 2020/10/27 上午10:03
 */
public class ExperimentOne {
    private static int[] aux;

    public static void main(String[] args) {
        int n = 10;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (int) (Math.random() * 10000 / 1234);
        }

        aux = new int[nums.length];

        print(nums, 0, nums.length - 1);
        mergeSort(nums, 0, nums.length - 1);
        print(nums, 0, nums.length - 1);
        System.out.println("-----------------------------------------");

        for (int i = 0; i < n; i++) {
            nums[i] = (int) (Math.random() * 10000 / 1234);
        }

        print(nums, 0, nums.length - 1);
        quickSort(nums, 0, nums.length - 1);
        print(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int lo = start;
            int hi = end;
            int num = nums[start];
            while (lo != hi) {

                while (lo < hi && nums[lo] <= num) lo++;
                swap(nums, lo, hi);
                while (lo < hi && nums[hi] >= num) hi--;
                swap(nums, lo, hi);

            }
            quickSort(nums, start, lo - 1);
            quickSort(nums, lo + 1, end);
        }
    }

    private static void swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }

    public static void mergeSort(int[] nums, int s, int e) {
        if (s < e) {
            int mid = (s + e) >> 1;
            mergeSort(nums, s, mid);
            mergeSort(nums, mid + 1, e);
            merge(nums, s, mid, e);
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
            } else if (aux[right] < aux[left]) {
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
