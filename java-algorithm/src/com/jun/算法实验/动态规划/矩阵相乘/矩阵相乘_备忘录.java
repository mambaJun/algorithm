package com.jun.算法实验.动态规划.矩阵相乘;

/**
 * @author Jun
 * @date 2020/11/18 下午10:00
 */
public class 矩阵相乘_备忘录 {
    static int N = 4;

    public static void main(String[] args) {
        int[] p = {10, 100, 5, 50};
        int[][] m = new int[N][N];
        int[][] s = new int[N][N];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                m[i][j] = 0x7fffffff;
            }
        }
        System.out.println(MatrixChainOrder2(p, m, s, 1, N - 1));
        PrintAnswer(s, 1, N - 1);
    }

    private static int MatrixChainOrder2(int[] p, int[][] m, int[][] s, int i, int j) {
        if (i == j) return 0;
        if (m[i][j] < 0x7fffffff) return m[i][j];
        for (int k = i; k < j; ++k) {
            int tmp = MatrixChainOrder2(p, m, s, i, k) + MatrixChainOrder2(p, m, s, k + 1, j) + p[i - 1] * p[k] * p[j];
            if (tmp < m[i][j]) {
                m[i][j] = tmp;
                s[i][j] = k;
            }
        }
        return m[i][j];
    }

    private static void PrintAnswer(int[][] s, int i, int j) {
        if (i == j) {
            System.out.printf("A%d", i);
        } else {
            System.out.printf("(");
            PrintAnswer(s, i, s[i][j]);
            PrintAnswer(s, s[i][j] + 1, j);
            System.out.printf(")");
        }
    }
}
