package com.jun.offer40最小的k个数;

import java.util.Arrays;

/**
 * @author Jun
 * @date 2021/2/12 下午8:01
 */
public class offer40最小的k个数 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 2, 1};
        int[] result = solution.getLeastNumbers(arr, 2);
        System.out.println(Arrays.toString(result));
    }
}


class Solution {
    int k;

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) return arr;

        this.k = k;

        sort(arr, 0, arr.length - 1, k);

        System.out.println(Arrays.toString(arr));

        return Arrays.copyOf(arr, k);
    }

    private void sort(int[] arr, int s, int e, int k) {
        if (s >= e) return;
        int left = s;
        int right = e;
        int num = arr[s];

        while (left < right) {
            while (left < right && arr[right] >= num) right--;
            swap(arr, left, right);
            while (left < right && arr[left] <= num) left++;
            swap(arr, left, right);
        }
        /*
            这个是在基础的快排上稍微做了一点点的改进，
        */
        if (left > k) {     // 基数左边继续排序，因为里面存在 多余 k 个数的数
            sort(arr, s, left - 1, k);
        }
        if (left < k) {     // 基数右边继续排序，因为里面存在 多余 k 个数的数
            sort(arr, left + 1, e, k);
        }
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}