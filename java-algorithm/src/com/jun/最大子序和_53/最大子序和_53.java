package com.jun.最大子序和_53;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/2/2 上午11:55
 */
public class 最大子序和_53 {
    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {-2, -1};
        int[] nums = {-2, -1, -2};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {

        if (nums == null || nums.length < 1) {
            return 0;
        }

        // 第一个开始的下标
        int firstValueIndex = getFirstValueIndex(nums);

        int max = nums[firstValueIndex];

        for (int i = firstValueIndex; i < nums.length; i++) {
            int sum = nums[i];
            max = sum > max ? sum : max;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                max = sum > max ? sum : max;
            }
        }
        return max;
    }

    // 从序列中第一个非负数开始，如果全负数则忽略
    public static int getFirstValueIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                return i;
            }
        }
        return 0;
    }
}
