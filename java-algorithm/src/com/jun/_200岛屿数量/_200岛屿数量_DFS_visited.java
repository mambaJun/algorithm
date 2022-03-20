package com.jun._200岛屿数量;

/**
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1：
 * 输入：grid = {
 * {'1','1','1','1','0'},
 * {'1','1','0','1','0'},
 * {'1','1','0','0','0'},
 * {'0','0','0','0','0'}
 * }
 * 输出：1
 * 示例 2：
 * 输入：grid = {
 * {'1','1','0','0','0'},
 * {'1','1','0','0','0'},
 * {'0','0','1','0','0'},
 * {'0','0','0','1','1'}
 * }
 * 输出：3
 * 提示：
 * m == grid.length
 * n == grid{i}.length
 * 1 <= m, n <= 300
 * grid{i}{j} 的值为 '0' 或 '1'
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2022/3/20 下午7:28
 */
public class _200岛屿数量_DFS_visited {
    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(solution.numIslands(grid));
    }

}

class Solution_DFS {
    /*

     */
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int res = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, visited);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        for (int k = 0; k < 4; k++) {
            int newX = i + DIRECTIONS[k][0];
            int newY = j + DIRECTIONS[k][1];
            if (isArea(grid, newX, newY) && grid[newX][newY] == '1' && !visited[newX][newY]) {
                dfs(grid, newX, newY, visited);
            }
        }
    }

    private boolean isArea(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        return i < 0 || i >= m || j < 0 || j >= n;
    }
}