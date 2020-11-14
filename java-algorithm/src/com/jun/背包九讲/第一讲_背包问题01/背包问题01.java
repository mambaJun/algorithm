package com.jun.背包九讲.第一讲_背包问题01;

/**
 * @author Jun
 * @date 2020/2/26 下午5:41
 */
public class 背包问题01 {
    public static void main(String[] args) {
        version1();
        version2();
    }

    private static void version2() {
        int N = 1010;
        int n = 4;
        int m = 5;

        int[] w = {0, 1, 2, 3, 4};
        int[] v = {0, 2, 4, 4, 5};
        // f[i][j], j重量下前i个物品
        int[] f = new int[N];

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i]; j--) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[m]);
    }

    private static void version1() {
        int n = 4;
        int m = 5;

        int[] w = {0, 1, 2, 3, 4};
        int[] v = {0, 2, 4, 4, 5};
        // f[i][j], j重量下前i个物品
        int[][] f = new int[6][6];

        // n number
        for (int i = 1; i <= n; i++) {
            // w number
            for (int j = 1; j <= m; j++) {
                if (j < w[i]) {
                    f[i][j] = f[i - 1][j];
                } else {
                    int num1 = f[i - 1][j];
                    int num2 = f[i - 1][j - w[i]] + v[i];
                    f[i][j] = Math.max(num1, num2);
                }
            }
        }
        System.out.println(f[n][m]);
    }


}
