package com.jun._415字符串相加;

/**
 * @author Jun
 * @date 2020/8/3 上午9:27
 */
public class _415字符串相加 {

    public static void main(String[] args) {
        System.out.println(addStrings("1", "9"));
    }

    /*
        和 2 链表 相加思路一样， 模拟加法过程

        还有种思路，是像 链表一样，如果有 结束了，可以直接将另一个剩下的直接插在结果前面
    */
    public static String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            carry += x + y;
            builder.insert(0, carry % 10);
            carry /= 10;
            i--;
            j--;
        }

        return builder.toString();
    }

}
