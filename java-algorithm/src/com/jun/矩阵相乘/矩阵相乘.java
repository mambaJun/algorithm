package com.jun.矩阵相乘;

/**
 * @author Jun
 * @date 2020/11/14 下午9:05
 */
public class 矩阵相乘 {
    public static void main(String[] args) {
        int n = 4;
        int[] p = new int[]{50, 10, 40, 30, 5};
        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];
        matrixChain(n, p, m, s);
    }

    private static void matrixChain(int n, int[] p, int[][] m, int[][] s) {
        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i + 1; j++) {
                int k = i + j - 1;
                m[i][j] = m[i + 1][j] + p[j] * p[j + 1] * p[k + 1];
                s[i][j] = j;
                for (int l = j + 1; l < i; l++) {
                    int t = m[j][l] + m[l + 1][k] + p[j] * p[l + 1] * p[k + 1];
                    if (t < m[j][k]) {
                        m[j][k] = t;
                        System.out.printf("更新m[%d][%d]为[%d]\n", j, k, t);
                        s[j][k] = l;
                        System.out.printf("更新m[%d][%d]为[%d]\n", j, k, l);
                    }
                }

                System.out.printf("最终求出：m[%d][%d]的值为%d", j, k, m[j][k]);
            }
        }
    }
}
