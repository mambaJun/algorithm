package com.jun._1_test;

import com.sun.org.apache.xerces.internal.impl.dv.xs.AnyURIDV;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Jun
 * @date 2020/10/14 下午9:46
 */
public class ThirdSearch {

    public static void main(String[] args) {
//        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums = {2, 4, 6, 7, 10};
        Arrays.sort(nums);

        for (int i = 1; i <= 10; i++) {
            System.out.println(thirdSearch(nums, i));
        }

//        System.out.println(binarySearch(nums, 60));
//        System.out.println(binarySearch(nums, 0, nums.length - 1, 60));
    }

    private static int thirdSearch(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int step = (right - left) / 3;

            if (nums[left + step] == k) return left + step;

            if (k < nums[left + step]) {
                right = left + step - 1;
                continue;
            }

            if (nums[left + step * 2] == k) return left + step * 2;

            if (k > nums[left + step * 2]) {
                left += step * 2 + 1;
                continue;
            }

            left += step + 1;
            right -= step + 1;
        }

        return -1;
    }

    private static int binarySearch(int[] nums, int s, int e, int k) {
        if (s > e) return -1;

        int mid = (s + e) >> 1;
        if (nums[mid] == k) return mid;

        return nums[mid] > k
                ? binarySearch(nums, s, mid - 1, k)
                : binarySearch(nums, mid + 1, e, k);
    }

    private static int binarySearch(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;

            if (nums[mid] == k) {
                return mid;
            }

            if (nums[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }


}
