package com.jun._54螺旋矩阵;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Jun
 * @date 2021/2/3 下午7:43
 */
public class _54螺旋矩阵 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solution.spiralOrder(matrix).toString());
    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return order;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int start = 0;
        while (rows > start * 2 && cols > start * 2) {
            spiralOrder(matrix, order, start++);
        }

        return order;
    }

    private void spiralOrder(int[][] matrix, List<Integer> order, int start) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int endRow = rows - 1 - start;
        int endCol = cols - 1 - start;

        // 从左到右
        for (int i = start; i <= endCol; i++) {
            order.add(matrix[start][i]);
        }
        // 从上到下
        for (int i = start + 1; i < endRow; i++) {
            order.add(matrix[i][endCol]);
        }
        // 从右到左(不只有 一行 start < endRow )
        for (int i = endCol; start < endRow && i >= start; i--) {
            order.add(matrix[endRow][i]);
        }
        // 从下到上 (不只有 一列 start < endCol )
        for (int i = endRow - 1; start < endCol && i > start; i--) {
            order.add(matrix[i][start]);
        }
    }
}