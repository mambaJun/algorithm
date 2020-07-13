package com.jun._55跳跃游戏;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/6/30 下午1:48
 */
public class _55跳跃游戏 {

    /*
        这个问题讨论的是能不能到达 最后一个位置
        reach 最远可以到达的位置
            reach = Math.max(i + nums[i], reach);
        [0, n-1] 和 reach 比较
        i 和 reach 进行比较
            在 i 的位置 如果：
                reach < i 的话，说明连 i 都 到达不了  返回 false 退出
                reach >= n - 1 的话，不管 i 是多少 都说明 可以到达 最后一个结果，返回 true 退出
    */

    public static boolean canJump(int[] nums) {
//        ArrayUtil.outputIntArray_1(nums);
        int reach = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // reach < i 的话，说明连 i 都 到达不了  返回 false 退出
            if (i > reach) {
                return false;
            }

            // reach 最远可以到达的位置
            reach = Math.max(i + nums[i], reach);

            // reach >= n - 1 的话，不管 i 是多少 都说明 可以到达 最后一个结果，返回 true 退出
            if (reach >= n - 1) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 1, 0, 4};
//        int[] nums = new int[]{3, 2, 1, 0, 4};
//        int[] nums = new int[]{2, 3, 1, 1, 4};
//        int[] nums = new int[]{0};
//        int[] nums = new int[]{2, 0, 0};
        System.out.println(canJump(nums));
    }
}
