package com.jun._64不同路径和;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   [1,3,1],
 * [],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/7/23 下午7:06
 */
public class _64不同路径和_dp {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

/*        int[][] grid = {
                {0, 1},
                {1, 0}
        };*/
        System.out.println(minPathSum(grid));
    }

    /*
        拿到这个题目立即想到 动态规划 解题，
        以这个样例为例：
            1 3 1
            1 5 1
            4 2 1

        初始化一个 二维 dp 数组用来存放 过程
        0 0 0       1 4 5
        0 0 0 ->    2 7 6
        0 0 0       6 8 7

        递推方程：用左边 上边中的 最小值 加上 自己 ，即为当前位置的 最小值
        dp[i][j] = dp[i - 1][j] < dp[i][j - 1] ? dp[i - 1][j] + grid[i][j] : dp[i][j - 1] + grid[i][j];
        注意：
            考虑边界问题

        下面考虑如何用一位数组来存放结果，后期如果想出来了再补上
     */
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //
                if (i == 0) {
                    dp[i][j] = j == 0 ? grid[i][j] : dp[i][j - 1] + grid[i][j];
                } else {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + grid[i][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] < dp[i][j - 1] ? dp[i - 1][j] + grid[i][j] : dp[i][j - 1] + grid[i][j];
                    }
                }
            }
        }
        print(dp);

        return dp[n - 1][m - 1];
    }

    private static void print(int[][] grid) {
        if (grid == null || grid.length == 0) return;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%d ", grid[i][j]);
            }
            System.out.println();
        }
    }

}
