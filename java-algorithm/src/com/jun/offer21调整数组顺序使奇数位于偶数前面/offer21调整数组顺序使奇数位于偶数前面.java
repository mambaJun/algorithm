package com.jun.offer21调整数组顺序使奇数位于偶数前面;

import java.util.Arrays;

/**
 * @author Jun
 * @date 2021/2/1 下午9:04
 */
public class offer21调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        int[] newNums = solution.exchange(nums);
        System.out.println(Arrays.toString(newNums));
    }
}

class Solution {
    /*
        双指针 思路，从前向后找 偶数， 从后向前找 奇数 交换，继续执行
    */
    public int[] exchange(int[] nums) {
        int n = 0;
        if (nums == null || (n = nums.length) < 2) return nums;

        int left = 0;
        int right = n - 1;

        while (left < right) {
            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }
            while (left < right && (nums[right] & 1) == 0) {
                right--;
            }
            swap(nums, left, right);
        }

        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}