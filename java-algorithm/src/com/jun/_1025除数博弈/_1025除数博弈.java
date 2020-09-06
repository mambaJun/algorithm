package com.jun._1025除数博弈;

import java.util.Arrays;

/**
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * <p>
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 1000
 *
 * @author Jun
 * @date 2020/5/9 上午7:28
 */
public class _1025除数博弈 {
    public static boolean divisorGame(int N) {
        /**
         * 这个题，为啥每个人选择1最好，不明白，最大的收获就是 备忘录数组
         */
        boolean[] dp = new boolean[N];

        dp[0] = false;
        dp[1] = true;
        dp[2] = false;

        for (int i = 4; i <= N; i++) {

            System.out.println(i + "-----------------");
            if (!dp[i - 1 - 1]) {
                dp[i - 1] = true;
            }
        }
        System.out.println("--------------------");

        return dp[N - 1];
    }

    public static void main(String[] args) {
        System.out.println(divisorGame(6));
    }
}
