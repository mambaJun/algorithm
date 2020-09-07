package com.jun._3无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/7/20 下午6:19
 */
public class _3无重复字符的最长子串_dp {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("dvdf"));
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("ckilbkd"));
//        System.out.println(lengthOfLongestSubstring("cdd"));
        System.out.println(lengthOfLongestSubstring("abba"));
    }
    /*
        max   0  1  2   3   3   3   3   2   1
        mark -1 -1 -1  -1   0   1   2   4   6
          i     0   1   2   3   4   5   6   7
                a   b   c   a   b   c   b   b
        i 为某一项
        max 为 i位置的最大值
        计算公式为
            max = max < i - mark ? i - mark : max;
         有一个小坑，如果存在的话，mark 只能 取最大值
            if (map.containsKey(ch)) {
                Integer tmp = map.get(ch);
                mark = mark < tmp ? tmp : mark;
            }
    */

    public static int lengthOfLongestSubstring(String s) {

        if (s == null) return 0;

        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int mark = -1;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                Integer tmp = map.get(ch);
                mark = mark < tmp ? tmp : mark;
            }
            max = max < i - mark ? i - mark : max;
            map.put(ch, i);
        }
        return max;
    }

}
