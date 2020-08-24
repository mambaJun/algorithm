package com.jun._459重复的子字符串;

/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abab"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * <p>
 * 输入: "aba"
 * <p>
 * 输出: False
 * 示例 3:
 * <p>
 * 输入: "abcabcabcabc"
 * <p>
 * 输出: True
 * <p>
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/8/24 上午10:56
 */
public class _459重复的子字符串 {
    public static void main(String[] args) {
        String s = "ababba";
        System.out.println(repeatedSubstringPattern(s));
    }

    public static boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int n = s.length();
        boolean ans = false;
        char first = s.charAt(0);
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == first && n % i == 0) {
                ans = equal(s, i);
                if (ans == true) {
                    return ans;
                }
            }
        }
        return ans;
    }

    private static boolean equal(String s, int step) {
        boolean ans = false;
        int len = step;
        String template = s.substring(0, len);

        while (len < s.length()) {
            ans = template.equals(s.substring(len, len + step));
            len += step;

            if (ans == false) {
                return ans;
            }
        }

        return ans;
    }
}
