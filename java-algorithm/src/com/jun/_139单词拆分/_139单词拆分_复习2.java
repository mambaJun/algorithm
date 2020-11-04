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
 * @date 2020/11/1 18:15
 */
public class _139单词拆分_复习2 {

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        list.add("applepen");
        list.add("pine");
        list.add("pineapple");
/*        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("aa");
        list.add("aaa");
        list.add("aaaa");
        list.add("aaaaa");
        list.add("aaaaaa");
        list.add("aaaaaaa");
        list.add("aaaaaaaa");
        list.add("aaaaaaaaa");
        list.add("aaaaaaaaa");
        list.add("aaaaaaaaaa");*/
        List<String> strings = wordBreak(s, list);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    static Map<Integer, List<String>> cache = new HashMap<>();

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();

        Deque<String> path = new LinkedList<>();
        Map<Integer, List<String>> cache = new HashMap<>();

        dfs(s, res, path, new HashSet<>(wordDict), 0, new Boolean[s.length()]);

        return res;
    }

    static boolean dfs(String s, List<String> res, Deque<String> path, Set<String> wordDict, int start, Boolean[] flags) {
        int n = s.length();

        if (start == n) {
            res.add(String.join(" ", path));
            return true;
        }

        for (int end = start + 1; end <= n; end++) {
            String str = s.substring(start, end);
            if (!wordDict.contains(str)) continue;
            if (end < n && flags[end] != null && !flags[end]) continue;

            path.addLast(str);
            flags[start] = dfs(s, res, path, wordDict, end, flags);
            path.removeLast();
        }

        return flags[start] = false;
    }
}
