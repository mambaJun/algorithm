package com.jun.util;

/**
 * @author Jun
 * @date 2020/2/2 下午12:21
 */
public class StringUtil {
    public static String printBlank(int n) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < n; i++) {
            string.append("  ");
        }
        return string.toString();
    }
}
