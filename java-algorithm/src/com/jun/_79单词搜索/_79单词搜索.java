package com.jun._79单词搜索;

/**
 * @author Jun
 * @date 2020/9/13 上午8:54
 */
public class _79单词搜索 {

    public static void main(String[] args) {
        char[][] board = {
                {'a'}
        };
        String word = "a";

        _79单词搜索 main = new _79单词搜索();
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
                if (dfs(board, visited, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    /**
     * @param board
     * @param visited
     * @param word
     * @param i       当前 x 坐标
     * @param j       当前 y 坐标
     * @param index   已经是第几个字符匹配了
     * @return
     */
    private boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int index) {
        // 字符不匹配，直接返回
        if (board[i][j] != word.charAt(index)) return false;
        // 已经是字符串的长度，返回 true
        if (index == word.length() - 1) return true;

        // 匹配过程
        visited[i][j] = true;
        // 匹配标记
        boolean flag = false;

        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};
        int m = board.length;
        int n = board[0].length;
        // 四个角度，遍历
        for (int k = 0; k < x.length; k++) {
            int newI = i + x[k];
            int newJ = j + y[k];

            if (0 <= newI && newI < m && 0 <= newJ && newJ < n && !visited[newI][newJ]) {
                //  如果 有符合的，就可以直接返回当前  DFS结果，不用再搜索 其他方向
                // 也是 剪枝的一种体现吧
                if (dfs(board, visited, word, newI, newJ, index + 1)) {
                    flag = true;
                    break;
                }
            }
        }
        // 恢复标记
        visited[i][j] = false;
        return flag;
    }
}
