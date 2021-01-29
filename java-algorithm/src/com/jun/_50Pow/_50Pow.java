package com.jun._50Pow;

/**
 * @author Jun
 * @date 2020/10/29 下午9:48
 */
public class _50Pow {
    public static void main(String[] args) {
//        System.out.println(myPow(2, 10));
        System.out.println(myPow(2.00000, -2147483648));
    }
    /*
        快速幂
        如 3^10 => 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3 * 3
        化为 9^5 => 9 * 9 * 9 * 9 * 9
        化为 81^2 * 9 => 81 * 81 * 9
        化为 6561 * 9
        底数每次翻倍
        指数每次折半，如果为奇数，则-1折半，-1直接乘到结果上
                A^(n/2) * A^(n/2)
        A^n =
                A^(n - 1/2) * A^(n - 1/2) * A
    */

    public static double myPow(double base, int power) {
        if (base == 0) return 0.0;
        if (power == 0) return 1.0;

        // p = -2147483648 的时候，取反时 已经 超出了 int 范围，所以用 long 代替
        long p = power;

        if (p < 0) {
            p = -p;
            base = 1 / base;
        }

        double res = 1.0;

        while (p > 0) {
            if ((p & 1) == 1) {
                res *= base;
            }
            p >>= 1;
            base *= base;
        }
        return res;
    }
}
