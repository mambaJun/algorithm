package com.jun._5最长回文子串;

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
public class _5最长回文子串_中心扩散法 {
    /**
     * 一层遍历每个节点，以该节点为中心往两边扩散
     * 小细节：
     * "ddd" 和 "dd" 类似两种情况 分别考虑
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int length = s.length();
        int start = 0;
        int max = 1;
        for (int i = 0; i < length - 1; i++) {
            int mid = i;
            int begin = mid;
            int end = mid;
            if (s.charAt(mid) == s.charAt(mid + 1) && s.charAt(mid) != s.charAt(mid + 2)) {
                begin = mid;
                end = mid + 1;
                while (s.charAt(begin) == s.charAt(end)) {
                    if (end - begin + 1 > max) {
                        max = end - begin + 1;
                        start = begin;
                    }
                    if (begin > 0) {
                        begin--;
                    } else {
                        break;
                    }
                    if (end < length - 1) {
                        end++;
                    } else {
                        break;
                    }
                }
                continue;
            }
            while (s.charAt(begin) == s.charAt(end)) {
                if (end - begin + 1 > max) {
                    max = end - begin + 1;
                    start = begin;
                }
                if (begin > 0) {
                    begin--;
                } else {
                    break;
                }
                if (end < length - 1) {
                    end++;
                } else {
                    break;
                }
            }

        }
        return s.substring(start, start + max);
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        String text1 = "CCC";
        System.out.println(longestPalindrome(text1));
    }

}