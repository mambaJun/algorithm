package com.jun._50Pow;

/**
 * @author Jun
 * @date 2020/10/29 下午9:48
 */
public class _50Pow {
    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }
    /*
        快速幂
        如 3^10 => 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3
        化为 9^5 => 9 * 9 * 9 * 9 * 9
        化为 81^2 * 9 => 81 * 81 * 9
        化为 6561 * 9
        底数每次翻倍
        指数每次折半，如果为奇数，则-1折半，-1直接乘到结果上
    */

    public static double myPow(double base, int power) {
        double res = 1;
        long p = power;
        if (p < 0) {
            p = -p;
            base = 1 / base;
        }
        while (p > 0) {
            if (p % 2 == 1) {
                res = res * base;
            }
            p = p >> 1;
            base *= base;
        }
        return res;
    }
}
