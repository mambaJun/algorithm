package com.jun._343整数拆分;

/**
 * @author Jun
 * @date 2020/7/30 上午8:19
 */
public class _343整数拆分 {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    /*
    一个数，可以分一步，也可以分两步，也可以分 n -1 步 比如 10

    1 9
    1 1 8
    1 1 1 7
    1 1 1 1 6
    ...
    j * (i - j) 当前情况的 结果
    j * dp[i  - j] 比较历史 情况 结果
    current_max 当前情况 最大值（动态结果）
    动态方程 max = Math.max(current_max, j * Math.max(i - j, dp[i - j]));

    这里的 dp 更像是 递归中的 备忘录
    */
    public static int integerBreak(int n) {
        // dp[i]：分拆数字i，可以得到的最大乘积为dp[i]
        int[] dp = new int[n + 1];

        /*
            动态规划 自下向上 开始计算
                dp[] 看作一个备忘录，记录 i 情况下 的 最优解，也就是 最大乘积为dp[i]
                dp[i]：分拆数字i，可以得到的最大乘积为dp[i]
            从 2 开始 是因为 0、1是不可分的，没有任何的意义，[2, n]，对每个 数进行拆分，从而获得最终答案
        */
        for (int i = 2; i <= n; i++) {
            // 记录当前结果的最大值
            int current_max = 0;
            // 这里的 i / 2 是 稍微优化了一下，如同 1 2 和 2 1 的关系
            for (int j = 1; j <= i / 2; j++) {
                current_max = Math.max(current_max, j * Math.max(i - j, dp[i - j]));
            }
            dp[i] = current_max;
        }
        return dp[n];
    }

}
