package com.jun._14最长公共前缀;

/**
 * @author Jun
 * @date 2020/7/22 上午8:30
 */
public class _14最长公共前缀_纵向扫描 {


    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = "";

        int index = 0;
        boolean flag = true;
        int n = strs.length;
        while (flag) {
            for (int i = 0; i < n; i++) {
                if (strs[i].length() == index) {
                    return prefix;
                }
                if (i == 0) {
                    continue;
                }
                if (strs[i].charAt(index) != strs[i - 1].charAt(index)) {
                    flag = false;
                    return prefix;
                }
            }
            prefix = prefix + strs[0].charAt(index++);
        }
        return prefix;
    }
}
