package com.jun._139单词拆分;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/6/17 下午9:52
 */
public class _139单词拆分_复习 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return word_break(0, s, new HashSet(wordDict), dp);
    }

    /**
     * 递归方法
     *
     * @param start
     * @param s
     * @param set
     * @return
     */
    public static boolean word_break(int start, String s, Set set, Boolean[] dp) {
        int length = s.length();
        // 递归出口
        if (start == length) {
            return true;
        }

        if (dp[start] != null) {
            return dp[start];
        }

        // 递归套路： 递归方法 + 递归出口
        for (int end = start + 1; end <= s.length(); end++) {
            if (set.contains(s.substring(start, end)) && word_break(end, s, set, dp)) {
                return dp[start] = true;
            }
        }
        return dp[start] = false;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");

        System.out.println(wordBreak(s, list));
    }
}
