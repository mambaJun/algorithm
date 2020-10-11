package com.jun._416分割等和子集;

import java.util.Arrays;

/**
 * @author Jun
 * @date 2020/10/11 上午11:34
 */
public class _416分割等和子集 {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 5};
//        int[] nums = {1, 5, 5, 11};
        int[] nums = {1, 3, 4, 4};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        if (nums == null || n <= 1) return false;

        Arrays.sort(nums);

        int leftSum = 0;
        int rightSum = 0;
        int left = -1;
        int right = n;


        while (left + 1 < right) {

            if (leftSum == rightSum) {
                // 左右相等，指针同时移动
                if (left + 1 < right) {
                    left++;
                    leftSum += nums[left];
                } else {
                    break;
                }


                if (left < right - 1) {
                    right--;
                    rightSum += nums[right];
                } else {
                    break;
                }

            } else if (leftSum < rightSum) {
                // 左边 小，左指针右移
                if (left + 1 < right) left++;
                else break;
                leftSum += nums[left];
            } else {
                // 右边小，右指针左移
                if (left < right - 1) right--;
                else break;
                rightSum += nums[right];
            }
        }

        System.out.println(n);
        System.out.printf("left = %d\n", left);
        System.out.printf("leftSum = %d\n", leftSum);
        System.out.printf("right = %d\n", right);
        System.out.printf("rightSum = %d\n", rightSum);
        return leftSum == rightSum;
    }
}
