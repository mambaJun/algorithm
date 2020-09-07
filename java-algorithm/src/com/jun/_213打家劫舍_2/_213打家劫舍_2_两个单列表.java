package com.jun._213打家劫舍_2;

import com.jun.util.ArrayUtil;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * @author Jun
 * @date 2020/5/21 下午10:42
 */
public class _213打家劫舍_2_两个单列表 {
    /**
     * 这个题目可以看作是 [0,nums.length - 1) 和 (0,nums.length - 1] 的最大值 的变体
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob_1(0, nums.length - 1, nums, 0), rob_1(0 + 1, nums.length - 1 + 1, nums, 1));
    }

    private static int rob_1(int start, int end, int[] nums, int offset) {
        int length = end - start;

        int[] dp = new int[length];

        for (int i = start; i < end; i++) {
            System.out.println(i);
            if (i == start) {
                dp[i - offset] = nums[i];
                ArrayUtil.outputIntArray_1(dp);
                continue;
            }
            if (i == start + 1) {
                dp[i - offset] = Math.max(dp[i - offset - 1], nums[i]);
                ArrayUtil.outputIntArray_1(dp);
                continue;
            }
            // 如果dp[i] = dp[i-1]意味着当前没偷
            // 如果dp[i] = dp[i - 2] + num[i] 说明偷了
            dp[i - offset] = Math.max(dp[i - offset - 2] + nums[i], dp[i - offset - 1]);
            ArrayUtil.outputIntArray_1(dp);
        }

        return dp[length - 1];
    }

    private static int rob_2(int start, int end, int[] nums, int offset) {
        int length = end - start + 1;
        int[] dp = new int[length];

        for (int i = start; i < end; i++) {
            if (i == start) {
                dp[i - offset] = nums[i];
                continue;
            }
            if (i == start + 1) {
                dp[i - offset] = Math.max(dp[i - 1 - offset], nums[i]);
                continue;
            }
            dp[i - offset] = Math.max(dp[i - offset - 1], dp[i - offset - 2] + nums[i]);
        }
        return dp[length - 1];
    }

    public static void main(String[] args) {
//        int[] nums = {2, 3, 2};
//        int[] nums = {2, 1, 1, 2};
//        int[] nums = {1, 2, 3, 1};
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }
}
