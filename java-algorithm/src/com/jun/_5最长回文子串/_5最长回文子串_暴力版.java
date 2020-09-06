package com.jun._5最长回文子串;

import java.util.ArrayList;
import java.util.List;

/**
 * 111111
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/3/31 上午8:32
 */
public class _5最长回文子串_暴力版 {
    /**
     * 1、判断是不是回文很简单 isPalindromic
     * 2、通过遍历方法 获取 具体某一情况
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String result = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i; j <= len; j++) {
                String substring = s.substring(i, j);
                int subStringLen = substring.length();
                if (isPalindromic(substring) && subStringLen > max) {
                    result = substring;
                    max = subStringLen;
                }
            }
        }

        return result;
    }

    private static boolean isPalindromic(String string) {
        int len = string.length();
        for (int i = 0; i < len; i++) {
            if (string.charAt(i) != string.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String text1 = "abcdefgfedcba".toUpperCase();
        System.out.println(longestPalindrome(text1));
    }

}