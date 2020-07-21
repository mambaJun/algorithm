package com.jun._9回文数;

/**
 * @author Jun
 * @date 2020/7/20 下午5:54
 */
public class _9回文数 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        return new StringBuilder(x + "").reverse().toString().equals(x + "");
    }

}
