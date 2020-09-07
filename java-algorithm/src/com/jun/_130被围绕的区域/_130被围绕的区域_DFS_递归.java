package com.jun._130被围绕的区域;

/**
 * @author Jun
 * @date 2020/8/11 上午10:17
 */
public class _130被围绕的区域_DFS_递归 {

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        solve(board);

        for (char[] chars : board) {
            for (char ch : chars) {
                System.out.printf("%c ", ch);
            }
            System.out.println();
        }

    }

    final static char O = 'O';
    final static char X = 'X';
    final static char mark = '#';

    public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isEdge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isEdge && board[i][j] == O) {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == O) board[i][j] = X;
                if (board[i][j] == mark) board[i][j] = O;
            }
        }
    }

    private static void dfs(char[][] board, int i, int j) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == X || board[i][j] == mark)
            return;

        board[i][j] = mark;
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

//    // dfs 递归
//    public static void solve(char[][] board) {
//        if (board == null || board.length == 0) return;
//
//        int m = board.length;
//        int n = board[0].length;
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                boolean isEdge = i == 0 || j == 0 || i == m - 1 || i == n - 1;
//                if (isEdge && board[i][j] == O) {
//                    dfs(board, i, j);
//                }
//            }
//        }
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
////                if (board[i][j] == O) board[i][j] = X;
////                if (board[i][j] == MARK) board[i][j] = O;
//                if (board[i][j] == O) board[i][j] = X;
//                if (board[i][j] == MARK) board[i][j] = O;
//            }
//        }
//    }
//
//    private static void dfs(char[][] board, int i, int j) {
//        int m = board.length;
//        int n = board[0].length;
//        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == X || board[i][j] == MARK) return;
//
//        board[i][j] = MARK;
//        // 上
//        dfs(board, i - 1, j);
//        // 下
//        dfs(board, i + 1, j);
//        // 左
//        dfs(board, i, j - 1);
//        // 右
//        dfs(board, i, j + 1);
//
//    }
}