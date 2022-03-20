package com.jun._200岛屿数量;

/**
 * @author Jun
 * @date 2022/3/20 下午8:10
 */
public class _200岛屿数量_DFS_NOT_visited {
    public static void main(String[] args) {
        Solution_DFS_N solution = new Solution_DFS_N();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(solution.numIslands(grid));
    }


}

class Solution_DFS_N {
    /*
    遍历二维网格上每一个位置，如果遇到 grid[i][j] 为 1,说明当前是一个岛屿，
    将该岛屿用 DFS ，变成海水，继续遍历，从而获得岛屿点个数
    */
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // 每发现一个岛屿，岛屿数量加一
                    res++;
                    // 用 DFS 把岛屿淹没
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        // 超出索引边界
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        // 已经是海水
        if (grid[i][j] == '0') return;
        // 将 (i, j) 变成海水
        grid[i][j] = '0';

        // 淹没上下左右的陆地
        for (int[] direction : DIRECTIONS) {
            dfs(grid, i + direction[0], j + direction[1]);
        }

/*
        // 淹没上下左右的陆地
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        */
    }
}