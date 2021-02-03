package com.jun.offer29顺时针打印矩阵;

import java.util.Arrays;

/**
 * @author Jun
 * @date 2021/2/3 下午4:38
 */
public class offer29顺时针打印矩阵 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        int[][] matrix = {{2}, {3}};
//        int[][] matrix = {{7}, {9}, {6}};
        System.out.println(Arrays.toString(solution.spiralOrder(matrix)));
    }

}

class Solution {
    int index = 0;

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] order = new int[rows * cols];

        int start = 0;
        while (rows > start * 2 && cols > start * 2) {
            spiralOrder(matrix, order, start++);
        }

        return order;
    }

    private void spiralOrder(int[][] matrix, int[] order, int start) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int endRow = rows - 1 - start;
        int endCol = cols - 1 - start;

        // 从左到右
        for (int i = start; i <= endCol; i++) {
            order[index++] = matrix[start][i];
        }
        // 从上到下
        for (int i = start + 1; i < endRow; i++) {
            order[index++] = matrix[i][endCol];
        }
        // 从右到左(不只有 一行 start < endRow )
        for (int i = endCol; start < endRow && i >= start; i--) {
            order[index++] = matrix[endRow][i];
        }
        // 从下到上 (不只有 一列 start < endCol )
        for (int i = endRow - 1; start < endCol && i > start; i--) {
            order[index++] = matrix[i][start];
        }

    }
}
