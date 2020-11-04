package com.jun._140单词拆分2;

import java.util.*;

/**
 * @author: Jun
 * @date: 2020/11/1 21:03
 */
public class _140单词拆分_普通回溯_超时版 {
    static String s;
    static Map<Integer, List<String>> memo = new HashMap<>();
    static Set<String> dict;

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

    /*
        这种写法理论上是可以 得到答案的，不过时间复杂度是 指数型的 解决小规模的可以使用
        优化：
            利用缓存，空间换时间
     */
    private static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();

        dfs(s, new HashSet<>(wordDict), new LinkedList<>(), 0, res);

        return res;
    }

    private static void dfs(String s, Set<String> set, Deque<String> path, int start, List<String> res) {
        int n = s.length();
        if (start == n) {
            res.add(String.join(" ", path));
            return;
        }

        for (int end = start + 1; end <= n; end++) {
            String substring = s.substring(start, end);
            if (!set.contains(substring)) continue;

            path.addLast(substring);
            dfs(s, set, path, end, res);
            path.removeLast();
        }
    }

}
