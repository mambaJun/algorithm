package com.jun.爬楼梯_70;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
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
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/2/1 下午4:45
 */
public class 爬楼梯_70 {

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {

        if (n <= 2) {
            return n;
        }

        if (results[n] == 0) {
            results[n] = climbStairs1(n - 1) + climbStairs1(n - 2);
        }

        return results[n];
    }
/*
3
1 1 1
1 2
2 1
*/

    /**
     * 递归 ＋ 备忘录 基本上算是 动态规划的效率
     */
    static int[] results = new int[100];

    public static int climbStairs1(int n) {

        if (n <= 2) {
            return n;
        }

        if (results[n] == 0) {
            results[n] = climbStairs1(n - 1) + climbStairs1(n - 2);
        }

        return results[n];
    }

    /**
     * 递归树 效率最低
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        return n <= 2 ? n : climbStairs(n - 1) + climbStairs(n - 2);
    }
}
