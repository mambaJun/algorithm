package com.jun._509斐波那契数列_509;

/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 * 示例 2：
 * <p>
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 示例 3：
 * <p>
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 *  
 * <p>
 * 提示：
 * <p>
 * 0 ≤ N ≤ 30
 * <p>
 *
 * @author Jun
 * @date 2020/2/1 下午4:22
 */
public class 斐波那契数列_509 {

    static int[] arr = new int[31];

    public static void main(String[] args) {

        System.out.println(fib3(6));
        System.out.println(fib3(5));

//        System.out.println(fib2(6));
//        System.out.println(fib2(5));

//        System.out.println(fib(6));
//        System.out.println(fib(5));

//        System.out.println(fib1(4));
//        System.out.println(fib1(3));

    }

    /**
     * 动态规划
     *
     * @param N
     * @return
     */
    public static int fib3(int N) {
        if (N < 2) {
            return N;
        }

        int[] arr = new int[N + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= N; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[N];
    }

    /**
     * 递归 优化　：　递归　＋ 备忘录
     *
     * @param N
     * @return
     */
    public static int fib2(int N) {
        if (N < 2) {
            return N;
        }

        if (arr[N] != 0) {
            return arr[N];
        }

        return arr[N] = fib2(N - 1) + fib2(N - 2);
    }

    public static int fib(int N) {
        if (N < 2) {
            return N;
        }
        int f0 = 0;
        int f1 = 1;

        while (N >= 2) {
            N--;
            int tmp = f1 + f0;
            f0 = f1;
            f1 = tmp;
        }
        return f1;
    }

    /**
     * 递归
     *
     * @param N
     * @return
     */
    public static int fib1(int N) {

        return N < 2 ? N : fib1(N - 1) + fib1(N - 2);
    }
}
