package com.jun.第N个泰波那契数_1137;

/**
 * 泰波那契序列 Tn 定义如下： 
 * <p>
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * <p>
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：4
 * 解释：
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：n = 25
 * 输出：1389537
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 37
 * 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/1/31 下午11:14
 */
public class 第N个泰波那契数_1137 {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(tribonacci(n));
        System.out.println("递归");
        System.out.println(tribonacci1(n));
    }

    /**
     * 滑动窗口法
     * 0 1 1 2 4 7 13
     * x y z
     *   x y z
     *     x y z
     *       x y z
     *
     * @param n
     * @return
     */
    public static int tribonacci(int n) {
        if (n == 0 || n == 1 || n == 2) return n == 0 ? 0 : 1;
        int x = 0;
        int y = 1;
        int z = 1;
        while (n > 2) {
            n--;
            int tmp = x + y + z;
            x= y;
            y = z;
            z = tmp;
        }
        return z;
    }

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public static int tribonacci1(int n) {
        System.out.println(printBlank(n) + n);
        if (n == 0 || n == 1 || n == 2) return n == 0 ? 0 : 1;
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

    public static String printBlank(int n) {
        StringBuilder blank = new StringBuilder();
        while ((n--) != 0) {
            blank.append("-");
        }
        return blank.toString();
    }
}
