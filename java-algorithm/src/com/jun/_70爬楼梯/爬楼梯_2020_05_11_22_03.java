package com.jun._70爬楼梯;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @author Jun
 * @date 2020/5/11 下午10:03
 */
public class 爬楼梯_2020_05_11_22_03 {

//    public static int climbStairs(int n) {
//        re
//    }

    static int[] dp = new int[100];

    public static int climbStairs(int n) {


        return n < 3 ? n : (dp[n] = dp[n] == 0 ? climbStairs(n - 1) + climbStairs(n - 2) : dp[n]);

//        if (n < 3) {
//            return n;
//        }
//
//        return dp[n] = dp[n] == 0 ? climbStairs(n - 1) + climbStairs(n - 2) : dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}