package com.jun._3无重复字符的最长子串;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jun
 * @date 2020/7/20 下午6:19
 */
public class _3无重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s == null) {
            return max;
        }

        Set set = new HashSet();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                max = max < set.size() ? set.size() : max;
                set.clear();
            }
            set.add(ch);
        }
        return max < set.size() ? set.size() : max;
    }

}
