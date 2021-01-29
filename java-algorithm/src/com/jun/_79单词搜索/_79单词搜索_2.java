package com.jun._79单词搜索;

/**
 * @author Jun
 * @date 2020/9/14 下午4:33
 */
public class _79单词搜索_2 {
    public static void main(String[] args) {
//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
//        String word = "ABCCED";
        char[][] board = {
                {'a'}
        };
        String word = "a";
        _79单词搜索_2 单词搜索_2 = new _79单词搜索_2();
        System.out.println(单词搜索_2.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        // 预处理
        if (board.length == 0 || word == null || "".equals(word)) return false;

        // 开始每个节点 进行处理
        int m = board.length;
        int n = board[0].length;
        boolean[][] visted = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, visted, i, j, 0)) return true;
            }
        }

        return false;
    }

    boolean dfs(char[][] board, String word, boolean[][] visted, int i, int j, int index) {
        if (index == word.length() - 1) return true;
        if (board[i][j] != word.charAt(index)) return false;

        boolean flag = false;
        // 上 下 左 右
        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};
        visted[i][j] = true;
        int m = board.length;
        int n = board[0].length;
        for (int k = 0; k < 4; k++) {
            int newI = i + x[k];
            int newJ = j + y[k];
            if (0 <= newI && newI < m && 0 <= newJ && newJ < n && !visted[newI][newJ]) {
                flag = dfs(board, word, visted, newI, newJ, index + 1);
                if (flag) break;
            }
        }
        visted[i][j] = false;
        return flag;
    }
}
