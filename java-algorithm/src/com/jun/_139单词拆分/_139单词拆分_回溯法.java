package com.jun._139单词拆分;

import java.util.*;

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
 * @date 2020/5/20 下午10:05
 */
public class _139单词拆分_回溯法 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        return word_break(0, s, new HashSet<>(wordDict));
    }

    private static boolean word_break(int start, String s, Set<String> set) {
        int length = s.length();
        if (length == start) {
            return true;
        }

        /*
        现在对回溯的理解：
            一般都是结合递归来实现回溯法
            一定规模的事件，从小开始，不符合就下一个，符合则继续
            问题是不是适合 结果 是或否 的问题？
            我的猜想，等刷回溯法的时候再总结
        */

        for (int end = start + 1; end <= length; end++) {
            if (set.contains(s.substring(start, end)) && word_break(end, s, set)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        System.out.println(wordBreak(s, wordDict));
    }

}