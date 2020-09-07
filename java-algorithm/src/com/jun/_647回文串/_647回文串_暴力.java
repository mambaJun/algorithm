package com.jun._647回文串;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * <p>
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *  
 * <p>
 * 提示：
 * <p>
 * 输入的字符串长度不会超过 1000 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/8/20 上午8:44
 */
public class _647回文串_暴力 {
    /*
        双层 遍历 枚举所有的情况，在枚举过程中判断 是不是回文，结果累加
        双层遍历 + 每一次回文判断，O(N^3)
    */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        if (s.length() == 1) return 1;

        int sum = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (isP(s.substring(i, j))) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private boolean isP(String s) {
        if (s == null || s.length() == 0) return false;
        if (s.length() == 1) return true;

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
