package com.jun.整数反转_7;

/**
 * @author Jun
 * @date 2020/1/21 下午2:39
 */
public class 整数反转_7 {

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * 注意:
     * <p>
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long result = 0;
        do {
            result = result * 10 + x % 10;
            x /= 10;
        } while (x != 0);
        return  result < Integer.MAX_VALUE &&  result > Integer.MIN_VALUE ? (int) result : 0;
    }

    public static int reverse1(int x) {
        long result = 0;
        do {
            result = result * 10 + x % 10;
            x /= 10;
        } while (x != 0);
        return (int) result == result ? (int) result : 0;
    }

    public static void main(String[] args) {
        System.out.println("+++++++++++++++++++++++");
        System.out.println(reverse(123));
    }
}
