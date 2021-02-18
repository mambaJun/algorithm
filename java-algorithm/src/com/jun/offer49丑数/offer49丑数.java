package com.jun.offer49丑数;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 * <p>
 * 1是丑数。
 * n不超过1690。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2021/2/18 下午10:16
 */
public class offer49丑数 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(10));
    }
}

class Solution {
    public int nthUglyNumber(int n) {
        if (n < 1) return 0;

        int two = 0;
        int three = 0;
        int five = 0;

        int[] dp = new int[n];
        dp[0] = 1;

        /*
         这个题目的难点在于 如何维护列表的顺序，使 dp[i] 为 第 i 个丑数
        int two = 0;
        int three = 0;
        int five = 0;
         分别作为记录 当前 生成 dp[i] 的时候，分别由几个 2 3 5 组成的状态

         提示：
            再回首的时候如果理解不了，可以 debug ，观察 two three five 和 dp[] 的变化
         */


        for (int i = 0; i < n; i++) {
            int num1 = dp[two] * 2;
            int num2 = dp[three] * 3;
            int num3 = dp[five] * 5;

            dp[i] = Math.min(num1, Math.min(num2, num3));

            if (dp[i] == num1) {
                two++;
            }
            if (dp[i] == num2) {
                three++;
            }
            if (dp[i] == num3) {
                five++;
            }
        }

        return dp[n - 1];
    }
}
