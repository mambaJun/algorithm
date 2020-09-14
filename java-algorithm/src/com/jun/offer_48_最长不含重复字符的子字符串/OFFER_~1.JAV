package com.jun.offer_48_最长不含重复字符的子字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Jun
 * @date: 2020/9/6 22:09
 */
public class offer_最长不含重复字符的子字符串 {
    /*
    DP
        tmpRes = tmpRes < i - j ? tmpRes + 1 : i - j;
    * */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (s == null || len <= 1) {
            return len == 1 ? 1 : 0;
        }

        int res = 0;
        int tmpRes = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            // 不是当前的 最后一次出现
            int j = map.getOrDefault(ch, -1);
            // 存入
            map.put(ch, i);

            tmpRes = tmpRes < i - j ? tmpRes + 1 : i - j;
            res = Math.max(res, tmpRes);
        }

        return res;
    }
}
