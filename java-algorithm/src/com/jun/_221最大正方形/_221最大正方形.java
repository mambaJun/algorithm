package com.jun._221最大正方形;

/**
 * @author Jun
 * @date 2020/11/19 下午9:34
 */
public class _221最大正方形 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
/*        char[][] matrix = {
                {'1', '1'},
                {'1', '1'}
        };*/

        System.out.println(solution.maximalSquare(matrix));
    }
}

/**
 * 动态规划 版本
 * 这个动态规划 确实挺有意思的， 先判断了一遍自己每个节点是不是一个正方形，以此作为 dp 的基础，开始dp，确实牛逼
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int a = matrix.length;
        if (a == 0) return 0;
        int b = matrix[0].length;

        int max = 0;
        int[][] dp = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    max = 1;
                }
            }
        }
        if (a <= 1 || b <= 1) return max;
        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {
                if (dp[i][j] == 1) {
                    dp[i][j] = min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                    if (dp[i][j] > max) max = dp[i][j];
                }

            }
        }
        return max * max;

    }

    public int min(int i, int i1, int i2) {
        int k = Math.min(i, i1);
        return Math.min(k, i2);
    }
}

/**
 * 暴力版
 * 如该当前坐标 值不是 0, 以该坐标为 左上方顶点， 边长 从 1开始，不断的加一，直至 不满足 正方形条件 返回
 */
class Solution1 {
    public int maximalSquare1(char[][] matrix) {
        int rows;
        int cols;
        if (matrix == null || (rows = matrix.length) == 0 || (cols = matrix[0].length) == 0) return 0;

        int[][] dp = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (matrix[i - 1][j - 1] == '0') {
                    continue;
                }
                if (dp[i][j] == 0) dp[i][j] = 1;
                int area = judge(matrix, i - 1, j - 1, 1);
                dp[i][j] = Math.max(dp[i][j], area * area);
            }
        }

        return dp[rows][cols];
    }

    public int maximalSquare(char[][] matrix) {
        int rows;
        int cols;
        if (matrix == null || (rows = matrix.length) == 0 || (cols = matrix[0].length) == 0) return 0;

        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '0') continue;
                if (res == 0) res = 1;

                int edge = judge(matrix, i, j, 1);
                res = Math.max(res, edge * edge);
            }
        }

        return res;
    }

    int judge(char[][] matrix, int leftX, int leftY, int edge) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (leftX + edge > rows || leftY + edge > cols) {
            return edge - 1;
        }

        for (int i = leftX; i < leftX + edge; i++) {
            for (int j = leftY; j < leftY + edge; j++) {
                if (matrix[i][j] == '0') {
                    return edge - 1;
                }
            }
        }

        return judge(matrix, leftX, leftY, edge + 1);
    }
}