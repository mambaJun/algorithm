package com.jun._55跳跃游戏;

/**
 * * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * * <p>
 * * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * * <p>
 * * 判断你是否能够到达最后一个位置。
 * * <p>
 * * 示例 1:
 * * <p>
 * * 输入: [2,3,1,1,4]
 * * 输出: true
 * * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * * 示例 2:
 * * <p>
 * * 输入: [3,2,1,0,4]
 * * 输出: false
 * * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * * <p>
 * * 来源：力扣（LeetCode）
 * * 链接：https://leetcode-cn.com/problems/jump-game
 * * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/7/4 下午9:02
 */
public class _55跳跃游戏_review_1 {

    public static boolean canJump(int[] nums) {
        int location = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (i > location) {
                return false;
            }

            location = Math.max(location, i + nums[i]);

            if (location >= n - 1) {
                return true;
            }
        }

        return true;
    }


    public static void main(String[] args) {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
    }
}
