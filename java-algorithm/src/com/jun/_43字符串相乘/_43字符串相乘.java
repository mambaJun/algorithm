package com.jun._43字符串相乘;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 提示：
 * 1 <= num1.length, num2.length <= 200
 * num1和 num2只能由数字组成。
 * num1和 num2都不包含任何前导零，除了数字0本身
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2022/3/19 下午10:01
 */
public class _43字符串相乘 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String num1 = "123";
        String num2 = "456";
        System.out.println(solution.multiply(num1, num2));
    }
}

class Solution {
    /*
        模拟：
            两数相乘，模拟乘法的方法
            比如 123 和 456
            123不动，用 456 的每一位去乘
            123     123     123
           ×  6   ×  5  ×   4
           ----    ----   -----
           1368    9120   45600

                   1368     10488
                 + 9120   + 45600
                 ------   -------
                  10488     56088
    */
    public String multiply(String num1, String num2) {
        if (num1 == null || "0".equals(num1) || num2 == null || "0".equals(num2)) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        StringBuilder res = new StringBuilder();
        for (int i = m - 1; i >= 0; i--) {
            StringBuilder builder = new StringBuilder();
            // 456的每一位，依次是 6 5 4
            int multiplier = num1.charAt(i) - '0';
            int carry = 0;
            // 加法前先 补0, 因为 用的 builder，从前想后加，如果从后向前加的话，就不需要这个步骤
            builder.append(addZero(m - 1 - i));
            for (int j = n - 1; j >= 0; j--) {
                int num = (num2.charAt(j) - '0') * multiplier + carry;
                builder.append(num % 10);
                carry = num / 10;
            }
            // 这个需要注意，循环结束后，需要考虑最后一个是否需要进位！！！！！！！！！！
            if (carry > 0) {
                builder.append(carry);
            }

            builder.reverse();
            res = new StringBuilder(add(res.toString(), builder.toString()));
        }

        return res.toString();
    }

    String addZero(int n) {
        StringBuilder builder = new StringBuilder();
        while (n-- > 0) {
            builder.append("0");
        }
        return builder.toString();
    }

    String add(String num1, String num2) {

        int m = num1.length();
        int n = num2.length();
        int add = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = m - 1, j = n - 1; i >= 0 || j >= 0; i--, j--) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;

            int num = a + b + add;
            builder.append(num % 10);
            add = num / 10;
        }
        // 这个需要注意，循环结束后，需要考虑最后一个是否需要进位！！！！！！！！！！
        if (add > 0) builder.append(add);
        return builder.reverse().toString();
    }
}