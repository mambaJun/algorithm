package com.jun._37解数独;

/**
 * @author: Jun
 * @date: 2020/9/15 9:18
 */
public class _37解数独 {
    // 回溯算法
    public void solveSudoku(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') dfs(board, i, j);
            }
        }
    }

    void dfs(char[][] board, int row, int column) {
        char start = '1';
        while ('9' - start >= 0) {
            if (check(board, row, column, start)) board[row][column] = start;

            start++;
        }
    }

    public boolean check(char[][] board, int row, int column, char num) {
        int rows = board.length;
        int columns = board[0].length;
        // 水平
        for (int i = 0; i < rows; i++) {
            if (i != row && board[row][i] == num) return false;
        }
        // 垂直
        for (int i = 0; i < columns; i++) {
            if (i != column && board[i][column] == num) return false;
        }
        // 九方格
        int startRow = row / 3 * 3;
        int startColumn = column / 3 * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startColumn; j < startColumn + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }
}
