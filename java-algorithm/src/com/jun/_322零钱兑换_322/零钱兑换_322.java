package com.jun._322零钱兑换_322;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * 说明:
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 *
 * @author Jun
 * @date 2020/2/1 下午6:42
 */
public class 零钱兑换_322 {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {

        for (int i = 10; i >= 0; i--) {
            for (int j = 10; j >= 0; j--) {
                for (int k = 10; k >= 0; k--) {
                    if (5 * i + 2 * j + 1 * k == amount) {
                        return i + j + k;
                    }
                }
            }
        }
        return -1;
    }
}
