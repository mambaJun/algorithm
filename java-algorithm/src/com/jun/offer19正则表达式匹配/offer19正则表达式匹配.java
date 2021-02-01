package com.jun.offer19正则表达式匹配;

/**
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释:因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释:".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释:因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * s可能为空，且只包含从a-z的小写字母。
 * p可能为空，且只包含从a-z的小写字母以及字符.和*，无连续的 '*'。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2021/1/31 下午2:50
 */
public class offer19正则表达式匹配 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "aa";
        String pattern = "aa";
        System.out.println(solution.isMatch(str, pattern));
    }
}

/*
题目分析：
    这个题目可以 从前向后（->） 或者 从后向前(<-) 开始都是可以的，没什么区别的，只是遍历的顺序不同而已
    每次的比较分为下面的几种情况（这里的是从 正则表达式的角度出发的）：
    1、p 中是个 字符，这种情况简单只需要判断是否一致即可（具有唯一性）
    2、p 中是 . ，这种情况下匹配任意 字符即可 （具有任意性）
    3、p 中是「字符 + *」组合，这种情况下就需要具体判断下了，毕竟是0和多的区别
 */
class Solution {
    public boolean isMatch(String str, String pattern) {
        int m = str.length();
        int n = pattern.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pattern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (match(str, pattern, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (match(str, pattern, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }

        return dp[m][n];
    }

    private boolean match(String str, String pattern, int i, int j) {
        if (i == 0) return false;

        if (pattern.charAt(j - 1) == '.') return true;

        return str.charAt(i - 1) == pattern.charAt(j - 1);
    }
}