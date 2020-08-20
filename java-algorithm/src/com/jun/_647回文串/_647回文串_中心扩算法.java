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
public class _647回文串_中心扩算法 {
    /*
        中心扩散法：
            以当前节点为中心，开始向两边扩散，过程中 分别对 奇偶数长度判断
            相比于 暴力法的好处 在于 节省了  回文判断的时间，和 无效 情况的数量
        比如：aabcb
        a
        aa
        a   aab
        ab
        b   abc
        bc
        c   bcb
        cb


    */
    public int countSubstrings(String s) {
        // 如果是 空 或者 长度 为0 返回 0 ，否则返回1
        if (s == null || s.length() <= 1) return s.length() == 1 ? 1 : 0;

        int sum = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {

            int l = i, r = i;
            // 长度 为 奇数
            while (0 <= l && r < n && s.charAt(l--) == s.charAt(r++)) sum++;
            l = i;
            r = i + 1;
            // 长度 为 偶数
            while (0 <= l && r < n && s.charAt(l--) == s.charAt(r++)) sum++;
        }
        return sum;
    }
}
