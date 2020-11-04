package com.jun._1_test;

/**
 * @author Jun
 * @date 2020/10/27 上午10:54
 */
public class 尾递归 {
    public static void main(String[] args) {
        int n = 5000;

        long start = System.currentTimeMillis();
        System.out.println(factorial(n));
        long l = System.currentTimeMillis();
        System.out.println(l - start);

        long l1 = System.currentTimeMillis();
        System.out.println(factorial(n, 0));
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
    }

    static int factorial(int n) {
        return n == 1 ? 1 : n + factorial(n - 1);
    }

    static int factorial(int n, int sum) {
        if (n == 1) return sum + n;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return factorial(n - 1, sum + n);
    }
}
