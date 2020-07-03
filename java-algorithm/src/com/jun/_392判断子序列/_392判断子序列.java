package com.jun._392判断子序列;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * 返回 false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/6/30 下午9:26
 */
public class _392判断子序列 {

    /* 递归
        这个题目的思路是双指针
        s t 分别有一个指针记录 位置
        s 利用天然的 下标索引 作为指针 记录 s 字符位置
        t 定义 location 作为 指针 记录 t 的位置
    */
    public static boolean isSubsequence(String s, String t) {
        if (!s.trim().equals("") && t.trim().equals("")) {
            return false;
        }

        if (s.trim().equals("") && t.trim().equals("")) {
            return true;
        }

        int location = -1;
        for (int i = 0; i < s.length(); i++) {
            // 如果可以进入一级循环中 说明 s 有效
            // 在 s 有效的情况下，t 已经无效了，说明 结果也就无效了
            if (location >= t.length() - 1) {
                return false;
            }
            for (int j = location + 1; j < t.length(); j++) {
                char sChar = s.charAt(i);
                char tChar = t.charAt(j);

                if (sChar == tChar) {
                    location = j;
                    break;
                }

                // 在 s 的一个字符已到达 t 的末尾，说明 s 不是 t 的子串
                if (sChar != tChar && j == t.length() - 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        String s = "abc";
//        String s = "axc";
        String s = "acd";
        String t = "ahbgdc";

        System.out.println(isSubsequence(s, t));
    }
}
