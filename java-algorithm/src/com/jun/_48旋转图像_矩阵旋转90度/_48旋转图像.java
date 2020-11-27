package com.jun._48旋转图像_矩阵旋转90度;

/**
 * @author Jun
 * @date 2020/11/27 下午3:48
 */
public class _48旋转图像 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        Solution solution = new Solution();
        printMatrix(matrix);
//        solution.矩阵逆时针旋转90度(matrix);
        solution.矩阵逆时针旋转180度(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] elements : matrix) {
            for (int element : elements) {
                System.out.printf("%d ", element);
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }
}

class Solution {
    /*
    本题是矩阵 顺势度旋转90度，
        1、先 将矩阵 原地 改成 逆置矩阵
        2、再将 每一行的 元素 逆置 ，原矩阵 顺时针旋转 90度就完成了
    思考题？
        如何矩阵 逆时针 旋转 90度如何操作？
        1、先 将矩阵 原地 改成 逆置矩阵
        2、首尾两 行依次 交换
     */
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        // 逆置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 逆置每一行
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                // System.out.println(left + "  " + right);
                int tmp = matrix[i][left];
                matrix[i][left++] = matrix[i][right];
                matrix[i][right--] = tmp;
            }
        }
    }

    /**
     * 矩阵 逆时针 旋转 90 度
     */
    public void 矩阵逆时针旋转90度(int[][] matrix) {
        int n = matrix.length;
        // 逆置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 首尾两 行依次 交换
        int up = -1;
        int down = n;
        while (up++ < down--) {
            for (int i = 0; i < n; i++) {
                int tmp = matrix[up][i];
                matrix[up][i] = matrix[down][i];
                matrix[down][i] = tmp;
            }
        }
    }

    /**
     * 矩阵 逆时针 旋转 180 度
     */
    public void 矩阵逆时针旋转180度(int[][] matrix) {
        int n = matrix.length;
        int time = 0;
        // 从外到内，沿 中心点 交换
        while (time < n / 2) {
            // 行
            for (int i = time + 0; i < n - time; i++) {
                int tmp = matrix[time][i];
                matrix[time][i] = matrix[n - time - 1][n - i - 1];
                matrix[n - time - 1][n - i - 1] = tmp;
            }

            // 列
            for (int i = time + 0 + 1; i < n - time - 1; i++) {
                int tmp = matrix[i][time];
                matrix[i][time] = matrix[n - i - 2][n - time - 1];
                matrix[n - i - 2][n - time - 1] = tmp;
            }
            printMatrix(matrix);
            time++;
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] elements : matrix) {
            for (int element : elements) {
                System.out.printf("%d ", element);
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }
}