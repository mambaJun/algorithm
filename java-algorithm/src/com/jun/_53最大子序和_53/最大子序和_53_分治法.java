package com.jun._53最大子序和_53;

/**
 * @author Jun
 * @date 2020/2/2 下午12:53
 */
public class 最大子序和_53_分治法 {
    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {-2, -1};
        int[] nums = {-2, -1, -2};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {

        int left = 0;
        int rigth = nums.length;
        int mid = (left + rigth) / 2;

        int max = nums[0];

        return 0;
    }
}