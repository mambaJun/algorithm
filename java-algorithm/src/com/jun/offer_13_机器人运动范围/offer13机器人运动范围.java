package com.jun.offer_13_机器人运动范围;

/**
 * @author Jun
 * @date 2021/1/28 下午7:45
 */
public class offer13机器人运动范围 {
    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(1, 2, 1));
    }
}

class Solution {

    public int movingCount(int rows, int cols, int threshold) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }

        boolean[] visited = new boolean[rows * cols];

        return movingCount(threshold, 0, 0, rows, cols, visited);
    }

    int movingCount(int threshold, int row, int col, int rows, int cols, boolean[] visited) {
        int count = 0;

        if (!check(threshold, row, col, rows, cols, visited)) {
            return count;
        }

        visited[row * cols + col] = true;

        // 上 下 左 右
        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};

        count = 1;

        for (int i = 0; i < 4; i++) {
            count += movingCount(threshold, row + x[i], col + y[i], rows, cols, visited);
        }

        return count;
    }

    boolean check(int threshold, int row, int col, int rows, int cols, boolean[] visited) {
        return 0 <= row && row < rows &&
                0 <= col && col < cols &&
                getDigitSum(row) + getDigitSum(col) <= threshold &&
                !visited[row * cols + col];
    }

    int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
