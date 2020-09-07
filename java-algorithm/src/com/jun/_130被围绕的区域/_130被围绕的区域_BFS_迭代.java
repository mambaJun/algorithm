package com.jun._130被围绕的区域;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Jun
 * @date 2020/8/11 上午10:17
 */
public class _130被围绕的区域_BFS_迭代 {

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
/*        char[][] board = {
                {'O', 'O'},
                {'O', 'O'}
        };*/

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
                    bfs(board, i, j);
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

    /*
        深搜 用 Stack 一路压栈 不出， 直到无路可走，栈内容 就是 深搜 路径
        广搜 用 Queue 一路 入队 ，入队 就是广搜的表现，同时出队，当队空时，就是广搜 完毕的时候
    */

    private static void bfs(char[][] board, int i, int j) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(i, j));
        board[i][j] = mark;
        int m = board.length;
        int n = board[0].length;
        while (!queue.isEmpty()) {
            Pos current = queue.poll();
            // up
            if (current.i - 1 >= 0 && board[current.i - 1][current.j] == O) {
                queue.add(new Pos(current.i - 1, current.j));
                board[current.i - 1][current.j] = mark;
            }
            // 右
            if (current.i + 1 < n && board[current.i + 1][current.j] == O) {
                queue.add(new Pos(current.i + 1, current.j));
                board[current.i + 1][current.j] = mark;
            }
            // 上
            if (current.j - 1 >= 0 && board[current.i][current.j - 1] == O) {
                queue.add(new Pos(current.i, current.j - 1));
                board[current.i][current.j - 1] = mark;
            }
            // 下
            if (current.j + 1 < m && board[current.i][current.j + 1] == O) {
                queue.add(new Pos(current.i, current.j + 1));
                board[current.i][current.j + 1] = mark;
            }
        }
    }
}