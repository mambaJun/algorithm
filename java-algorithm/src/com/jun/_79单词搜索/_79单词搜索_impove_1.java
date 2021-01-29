package com.jun._79单词搜索;

/**
 * @author Jun
 * @date 2020/9/13 上午8:54
 */
public class _79单词搜索_impove_1 {

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        String word = "ABCB";

        _79单词搜索_impove_1 main = new _79单词搜索_impove_1();
        System.out.println(main.exist(board, word));
    }

    // BFS 和 DFS都可以的， 优先考虑DFS
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || word == null || "".equals(word)) return true;

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // DFS每个节点，
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param board
     * @param word
     * @param i     当前 x 坐标
     * @param j     当前 y 坐标
     * @param index 已经是第几个字符匹配了
     * @return
     */
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // 已经是字符串的长度，返回 true
        if (index == word.length()) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        // 字符不匹配，直接返回
        System.out.println(board[i][j]);
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        // up
        if (dfs(board, word, i - 1, j, index + 1)) {
            return true;
        }
        // down
        if (dfs(board, word, i + 1, j, index + 1)) {
            return true;
        }
        // left
        if (dfs(board, word, i, j - 1, index + 1)) {
            return true;
        }
        // right
        if (dfs(board, word, i, j + 1, index + 1)) {
            return true;
        }
        return false;
    }
}
