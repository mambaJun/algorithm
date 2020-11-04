package com.jun._140单词拆分2;

import java.util.*;

/**
 * @author: Jun
 * @date: 2020/11/1 21:03
 */
public class _140单词拆分2 {

    static Map<Integer, List<String>> memory = new HashMap<>();
    static Set<String> dict;

    public static List<String> wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        return dfs(s, 0);
    }

    private static List<String> dfs(String s, int start) {
        if (memory.containsKey(start)) return memory.get(start);
        if (start >= s.length()) return null;

        List<String> res = new ArrayList<>();

        for (int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            if (!dict.contains(sub)) continue;

            List<String> last = dfs(s, end);
            if (last != null) res.add(String.join(" ", last));
        }

        memory.put(start, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        list.add("applepen");
        list.add("pine");
        list.add("pineapple");
        int[] res = {1, 2, 3, 4, 5, 6, 7};
        int[] ints = Arrays.copyOf(res, 3);
        System.out.println(Arrays.toString(ints));
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
//        List<String> strings = wordBreak(s, list);
//        for (String string : strings) {
//            System.out.println(string);
//        }
    }
}
