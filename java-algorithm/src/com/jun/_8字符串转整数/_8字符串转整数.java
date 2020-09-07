package com.jun._8字符串转整数;

/**
 * @author Jun
 * @date 2020/7/27 上午8:53
 */
public class _8字符串转整数 {
    public static void main(String[] args) {
        System.out.println(myAtoi("      -11919730356x"));
    }

    /*
        字符串必须是 有效的数字开头，否则不符合 返回0

    */
    public static int myAtoi(String str) {

        if (str == null || "".equals(str = str.trim()) || str.length() == 0) return 0;

        long res = 0;
        // 是不是 负数的标记
        boolean flag = false;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            Character nextChar = null;
            boolean next = false;
            if (i + 1 < length) {
                nextChar = str.charAt(i + 1);
                next = isNumber(nextChar);
            }
            boolean current = isNumber(ch);


            if (ch != '-' && ch != '+' && !current && res == 0) break;

            if (ch == '+' && res == 0 && i + 1 < length && next) {
                continue;
            }

            if (ch == '-' && res == 0 && i + 1 < length && next) {
                flag = next;
                continue;
            }

            if (current) {
                res *= 10;
                res += ch - '0';
            }

            if (res > Integer.MAX_VALUE) {
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            if (i + 1 < length && !next) {
                break;
            }
        }

        return (int) (flag ? -res : res);
    }

    private static boolean isNumber(char ch) {
        return '0' <= ch && ch <= '9';
    }

}
