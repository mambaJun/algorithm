package com.jun._1143最长公共子序列;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * <p>
 * 若这两个字符串没有公共子序列，则返回 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 * <p>
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 * <p>
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 * <p> *
 *
 * @author Jun
 * @date 2020/3/31 上午8:32
 */
public class _1143最长公共子序列_dp {

/*
   a c a e c
 0 0 0 0 0 0
a0 1 1 1 1 1
b0 1 1 1 1 1
c0 1 2 2 2 2
c0 1 2 2 2 3
c0 1 2 2 2 3


   a s c e c
   0 0 0 0 0
a0 1 0 0 0 0
b0 0 1 1 1 1
c0 1 1 2 0 0
c0 0 0 0 2 2
c0
题解：
    大概：
        两个事物进行对比，可以看作二维数组。
        无论我选中二维数组中的任一坐标，都可以得到当前位置的最长子序列值（减而治之 大事化小）
    细节：
        很巧妙的将两个字符串变成了一个二位数组，坐标全为 0，从坐标轴到（n,m）出发
        初始状态：数组全 0
        状态方程 dp[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1)
                        ? dp[i - 1][j - 1] + 1
                        : Math.max(dp[i - 1][j], dp[i][j - 1]);
        刚开始我以为
        当 text1.charAt(i - 1) == text2.charAt(j - 1)满足的时候，
        i++
        j++
        其他没有做到的地方 为 初始状态 0
        但是，
        仔细将上面的数组按照程序画了一遍就明白了，
        即时 text1.charAt(i - 1) == text2.charAt(j - 1)满足的时候
        只进行 j++
        这样，就能保证，无论我选中二维数组中的任一坐标，都可以得到当前位置的最长子序列值
*/

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {

                dp[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1)
                        ? dp[i - 1][j - 1] + 1
                        : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        String text1 = "abcd";
        String text2 = "adcc";

        System.out.println(longestCommonSubsequence(text1, text2));
    }
}