package com.jun._28实现strStr;

/**
 * @author Jun
 * @date 2020/7/22 上午10:31
 */
public class _28实现strStr {

    public static void main(String[] args) {
        String hay = "a";
        String needle = "a";

        System.out.println(strStr(hay, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            System.out.printf("-----------i = %d ---------------------\n", i);
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int j = 0; j <= needle.length(); j++) {
                    System.out.printf("---j = %d --- \n", j);
                    if (j == needle.length()) {
                        return i;
                    }

                    if (i + j >= haystack.length()) {
                        return -1;
                    }

                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
            }
        }
        return -1;
    }
}
