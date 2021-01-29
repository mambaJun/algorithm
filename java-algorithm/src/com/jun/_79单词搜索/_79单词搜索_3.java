package com.jun._79单词搜索;

/**
 * @author Jun
 * @date 2021/1/27 下午10:41
 */
public class _79单词搜索_3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(solution.exist(board, word));
    }
}

class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || word == null || "".equals(word)) return false;

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visted = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, visted, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visted, int row, int col, int index) {
        if (board[row][col] != word.charAt(index)) return false;
        if (index == word.length() - 1) return true;

        // 上 下 左 右
        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};

        int rows = board.length;
        int cols = board[0].length;

        visted[row][col] = true;

        boolean flag = false;

        for (int i = 0; i < 4; i++) {
            int newRow = row + x[i];
            int newCol = col + y[i];
            // !visted[newRow][newCol] 即将检查的新的是否已经 在当前路径上
            if (0 <= newRow && newRow < rows && 0 <= newCol && newCol < cols && !visted[newRow][newCol]) {
                //  如果 有符合的，就可以直接返回当前  DFS结果，不用再搜索 其他方向
                // 也是 剪枝的一种体现吧
                flag = dfs(board, word, visted, newRow, newCol, index + 1);
                if (flag) break;
            }
        }

        visted[row][col] = false;

        return flag;
    }
}
