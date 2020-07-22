package com.jun._198打家劫舍;

import com.jun.util.ArrayUtil;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,2,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * <p>
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/5/21 下午1:12
 */
public class _198打家劫舍_dp {
    /**
     * 这里先把 初始状态的 给设置了,对于这个题目来说 dp[0]和dp[1]算是初始状态
     * 思路还是从小规模到大规模,每个规模上都求出 最大值,到结果自然而然的就是结果了
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

        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            System.out.println(i);
            if (i == 0) {
                dp[i] = nums[i];
                ArrayUtil.outputIntArray_1(dp);
                continue;
            }
            if (i == 1) {
                dp[i] = Math.max(dp[i - 1], nums[i]);
                ArrayUtil.outputIntArray_1(dp);
                continue;
            }
            // 如果dp[i] = dp[i-1]意味着当前没偷
            // 如果dp[i] = dp[i - 2] + num[i] 说明偷了
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            ArrayUtil.outputIntArray_1(dp);
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 9, 3, 1};
//        int[] nums = {2, 1, 1, 2};
        int[] nums = {2, 3, 2};
        System.out.println(rob(nums));
    }
}
