package com.jun._45跳跃游戏2;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/7/3 下午11:39
 */
public class _45跳跃游戏2 {

    /*
        和 跳跃游戏 游戏的区别在于，跳跃游戏2 总能到达结尾，跳跃游戏就不一定了，毕竟两个问题的侧重点不在一起

        这个题目也是用的 贪心算法的思路，沿用的是 跳跃游戏的思路，每次跳最远的距离
           maxPostion 标记 跳跃的最远距离
                具体意思是：从 [0,i] 中 最远可以跳 maxPostion
           end 边界，用来计算步数的，因为题目是最少步数，所以等到 i == end 时候才更新 end
                遇到边界，就更新边界，并且步数加一
        因为这个题目是最小距离：
        end 是 整个过程中 一个 局部最远标记，
        i == end 是 已经跳到 过程中的最远标记，
        此时更新 end , 是为了用最少的步走最远

        试想如果题目是求最多步数的话，同样也是贪心思路，只不过将 max 改成 min即可

    */
    public static int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            // 跳跃的最远距离
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                // 遇到边界，就更新边界，并且步数加一
                steps++;

                // 优化 如果边界已经 到达最后的话，说明当前步数最小
                if (end >= length - 1) {
                    return steps;
                }
            }
        }
        return steps;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }
}
