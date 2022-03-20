package com.jun._200岛屿数量;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jun
 * @date 2022/3/20 下午8:42
 */
public class _200岛屿数量_BFS {
    public static void main(String[] args) {
        Solution_BFS solution = new Solution_BFS();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(solution.numIslands(grid));
    }
}

class Solution_BFS {
    private static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(grid, i, j, visited);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int i, int j, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * cols + j);
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int curX = cur / cols;
            int curY = cur % cols;
            for (int k = 0; k < 4; k++) {
                int newX = curX + DIRECTIONS[k][0];
                int newY = curY + DIRECTIONS[k][1];
                if (inArea(grid, newX, newY) && grid[newX][newY] == '1' && !visited[newX][newY]) {
                    queue.offer(newX * cols + newY);
                    // 特别注意：在放入队列以后，要马上标记成已经访问过，语义也是十分清楚的：反正只要进入了队列，迟早都会遍历到它
                    // 而不是在出队列的时候再标记，如果是出队列的时候再标记，会造成很多重复的结点进入队列，造成重复的操作，这句话如果你没有写对地方，代码会严重超时的

                    visited[newX][newY] = true;
                }
            }
        }
    }

    private boolean inArea(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        return 0 <= i && i < rows && 0 <= j && j < cols;
    }
}