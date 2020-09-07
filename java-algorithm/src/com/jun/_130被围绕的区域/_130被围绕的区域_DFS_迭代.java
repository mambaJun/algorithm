package com.jun._130被围绕的区域;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Jun
 * @date 2020/8/11 上午10:17
 */
public class _130被围绕的区域_DFS_迭代 {

    public static void main(String[] args) {
//        char[][] board = {
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}
//        };

//        char[][] board = {
//                {'O', 'O'},
//                {'O', 'O'}
//        };

//        char[][] board = {
//                {'X', 'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'O', 'X'},
//                {'X', 'O', 'X', 'O', 'X'},
//                {'X', 'O', 'O', 'O', 'X'},
//                {'X', 'O', 'X', 'X', 'X'}
//        };
        char[][] board = {
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}
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

    static class Pos {
        int i;
        int j;

        Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

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

//        if (i < 0 || j < 0 || i >= rows || j >= columns || board[i][j] == X || board[i][j] == mark) return;

        Stack<Pos> stack = new Stack<>();
        // 标记成 #
        board[i][j] = mark;
        stack.push(new Pos(i, j));
        int rows = board.length;
        int columns = board[0].length;
        while (!stack.isEmpty()) {
            Pos current = stack.peek();
            //  上
            if (current.i - 1 >= 0 && board[current.i - 1][current.j] == O) {
                stack.push(new Pos(current.i - 1, current.j));
                board[current.i - 1][current.j] = mark;
//                continue;
            }
            // 下
            if (current.i + 1 < rows && board[current.i + 1][current.j] == O) {
                stack.push(new Pos(current.i + 1, current.j));
                board[current.i + 1][current.j] = mark;
//                continue;
            }
            // 左
            if (current.j - 1 >= 0 && board[current.i][current.j - 1] == O) {
                stack.push(new Pos(current.i, current.j - 1));
                board[current.i][current.j - 1] = mark;
//                continue;
            }
            // 右
            if (current.j + 1 < columns && board[current.i][current.j + 1] == O) {
                stack.push(new Pos(current.i, current.j + 1));
                board[current.i][current.j + 1] = mark;
//                continue;
            }
            stack.pop();
        }
    }

//    private static void dfs(char[][] board, int i, int j) {
//        Stack<Pos> stack = new Stack<>();
//        stack.push(new Pos(i, j));
//        board[i][j] = mark;
//        int m = board.length;
//        int n = board[0].length;
//        while (!stack.isEmpty()) {
////            Pos current = stack.peek();
//            Pos current = stack.pop();
//            // up
//            if (current.i - 1 >= 0 && board[current.i - 1][current.j] == O) {
//                stack.push(new Pos(current.i - 1, current.j));
//                board[current.i - 1][current.j] = mark;
////                continue;
//            }
//            // down
//            if (current.i + 1 < m && board[current.i + 1][current.j] == O) {
//                stack.push(new Pos(current.i + 1, current.j));
//                board[current.i + 1][current.j] = mark;
////                continue;
//            }
//            // right
//            if (current.j - 1 >= 0 && board[current.i][current.j - 1] == O) {
//                stack.push(new Pos(current.i, current.j - 1));
//                board[current.i][current.j - 1] = mark;
////                continue;
//            }
//            // left
//            if (current.j + 1 < n && board[current.i][current.j + 1] == O) {
//                stack.push(new Pos(current.i, current.j + 1));
//                board[current.i][current.j + 1] = mark;
////                continue;
//            }
////            stack.pop();
//        }
//    }
}