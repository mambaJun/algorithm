package com.jun.offer_48_最长不含重复字符的子字符串;

/**
 * @author: Jun
 * @date: 2020/9/6 22:09
 */
public class offer_最长不含重复字符的子字符串_双指针 {
    // 双指针
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (s == null || len <= 1) return len == 1 ? 1 : 0;

        int res = 0;

        int[] arr = new int[128];
        for (int i = 0, j = 0; i < len; i++) {
            char ch = s.charAt(i);
            arr[ch]++;

            while (arr[ch] > 1) {
//                如果有相同的，一直向后走
                arr[s.charAt(j++)]--;
            }

            res = Math.max(res, i - j + 1);
        }

        return res;
    }
}
