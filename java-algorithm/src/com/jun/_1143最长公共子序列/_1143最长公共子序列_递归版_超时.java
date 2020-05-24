package com.jun._1143最长公共子序列;

import java.lang.reflect.Array;
import java.util.Arrays;

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
public class _1143最长公共子序列_递归版_超时 {

    public static int longestCommonSubsequence(String text1, String text2) {

        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int index1 = 0;
        int index2 = 0;
        return lcs(chars1, index1, chars2, index2);
    }

    private static int lcs(char[] chars1, int index1, char[] chars2, int index2) {

        if (index1 >= chars1.length || index2 >= chars2.length) {
            return 0;
        }

        if (chars1[index1] == chars2[index2]) {
            return lcs(chars1, index1 + 1, chars2, index2 + 1) + 1;
        }

        return Math.max(
                lcs(chars1, index1 + 1, chars2, index2),
                lcs(chars1, index1, chars2, index2 + 1)
        );
    }

    public static void main(String[] args) {
        String text1 = "abcd";
        String text2 = "adcc";

        System.out.println(longestCommonSubsequence(text1, text2));
    }
}