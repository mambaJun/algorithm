package com.jun.矩阵相乘;

/**
 * 参考思路
 * https://www.cnblogs.com/scarecrow-blog/p/3712580.html
 *
 * @author Jun
 * @date 2020/11/14 下午9:05
 */
public class 矩阵相乘 {
    public static void main(String[] args) {
        int[] p = new int[]{10, 100, 5, 50};
        int n = p.length;
        int[][] m = new int[n][n];
        int[][] s = new int[n][n];
        matrixChain(n - 1, p, m, s);
        System.out.println(matrixChain(p, m, s, 1, n - 1));
    }


    private static int matrixChain(int[] p, int[][] m, int[][] s, int i, int j) {

        if (i == j) {
            return 0;
        }
        if (m[i][j] < 0x7fffffff) {
            return m[i][j];
        }

        for (int k = i; k < j; ++k) {

            int tmp = matrixChain(p, m, s, i, k) + matrixChain(p, m, s, k + 1, j) + p[i - 1] * p[k] * p[j];
            if (tmp < m[i][j]) {
                m[i][j] = tmp;
                s[i][j] = k;
            }
        }
        return m[i][j];
    }

    private static void matrixChain(int n, int[] p, int[][] m, int[][] s) {
        // m[i][i]只有一个矩阵，所以相乘次数为0，即m[i][i]=0
        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }
        // i 矩阵链 的长度
        // i = 2 ,计算 m[i, i+1] i={1,2,...,n - 1}
        // 长度 i=2 的链 的 最小代价
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < n - i + 1; j++) {
                // 以j为起始位置，k 为长度为i的链的末位
                int k = i + j - 1;
                // l 从 j 到 l - 1 ,以 l 为位置划分
                m[j][k] = 0x7fffffff;
                for (int l = j; l <= k - 1; l++) {
                    int tmp = m[j][l] + m[l + 1][k] + p[j - 1] * p[l] * p[k];
                    if (tmp < m[j][k]) {
                        m[j][k] = tmp;
                        s[j][k] = k;
                    }
                }
            }
        }

        System.out.println(m[1][n - 1]);
    }
}


/*        int l, i, j, k, q = 0;
        //m[i][i]只有一个矩阵，所以相乘次数为0，即m[i][i]=0;
        for (i = 1; i < n; i++) {
            m[i][i] = 0;
        }
        //l表示矩阵链的长度
        // l=2时，计算 m[i,i+1],i=1,2,...,n-1 (长度l=2的链的最小代价)
        for (l = 2; l <= n; l++) {
            for (i = 1; i <= n - l + 1; i++) {
                j = i + l - 1; //以i为起始位置，j为长度为l的链的末位，
                m[i][j] = 0x7fffffff;
                //k从i到j-1,以k为位置划分
                for (k = i; k <= j - 1; k++) {
                    q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }*/
