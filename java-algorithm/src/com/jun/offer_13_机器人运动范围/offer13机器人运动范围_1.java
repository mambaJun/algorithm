package com.jun.offer_13_机器人运动范围;

/**
 * @author Jun
 * @date 2021/1/28 下午7:53
 */
public class offer13机器人运动范围_1 {
    public static void main(String[] args) {
//        System.out.println(new offer13机器人运动范围_1().movingCount(1, 2, 1));
        System.out.println(new Solution().movingCount(1, 2, 1));
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    private int movingCount(int rows, int cols, int threshold) {
        if (threshold == 0) {
            return 1;
        }
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }

        boolean[][] vis = new boolean[rows][cols];
        int ans = 1;
        vis[0][0] = true;

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if ((row == 0 && col == 0) || get(row) + get(col) > threshold) {
                    continue;
                }
                // 边界判断
                if (row - 1 >= 0) {
                    vis[row][col] |= vis[row - 1][col];
                }
                if (col - 1 >= 0) {
                    vis[row][col] |= vis[row][col - 1];
                }
                ans += vis[row][col] ? 1 : 0;
            }
        }
        return ans;
    }


    private static class Solution {
        boolean[][] visited;
        int m, n, k;

        public int movingCount(int m, int n, int k) {
            this.m = m;
            this.n = n;
            this.k = k;
            this.visited = new boolean[m][n];
            return dfs(0, 0, 0, 0);
        }

        private int dfs(int i, int j, int si, int sj) {
            if (i < 0 || j < 0 || i >= m || j >= n || si + sj > k || visited[i][j] == true) {
                return 0;
            }
            visited[i][j] = true;
            return 1 + dfs(i + 1, j, (i + 1) % 10 == 0 ? si - 8 : si + 1, sj) + dfs(i, j + 1, si, (j + 1) % 10 == 0 ? sj - 8 : sj + 1);
        }
    }
}