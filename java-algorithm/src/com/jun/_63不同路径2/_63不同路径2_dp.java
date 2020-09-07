package com.jun._63不同路径2;

import com.jun.util.ArrayUtil;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/5/11 下午12:09
 */
public class _63不同路径2_dp {

    public static int optimization(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first column
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return obstacleGrid[R - 1][C - 1];
    }

    /**
     * 这里能 写出来很开心了，算是自己想的快要接近答案，却犯了下面的错误，不过还是很开心，下面说说这个问题的优化
     * 通过前几个 形成了惯性思维，是dp的题目都是 自己给它申请的 dp一维或者二维数组
     * 这个题目的优化：
     * 因为自己本身就是一个数组，跟我们定义的 数组结构一样，而且动态规划的特点就是从小到大
     * 我们就可以利用这个从小到大的特点，在自身上改，而且在这个过程中不会影响到尚未处理的部分，妙妙妙，妙不可言啊！！！！
     * 优化方法 参考 optimization(int[][] obstacleGrid)
     *
     * @param obstacleGrid1
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid1) {

        int[][] obstacleGrid = {
                {0, 0},
                {1, 1},
                {0, 0}
        };

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 这个是错误的版本，错在哪里？
     * {0, 0},
     * {1, 1},
     * {0, 0}
     * 在这个例子中，[0][1]为1 ，那么 [0][2]的结果肯定是 0 不是1，为啥？因为只能往下和往右，上面有障碍，就不会走到这个位置
     * 推理 ：
     * 不管是横还是纵方向，只要前面有 1（障碍）存在，后面的肯定是0
     * 我这么写
     * if (i == 0 || j == 0) {
     * dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : 1;
     * continue;
     * }
     * 错误很明显，最简单的情况给搞错了
     *
     * @param obstacleGrid1
     * @return
     */
    public static int uniquePathsWithObstacles_ERROR(int[][] obstacleGrid1) {

        int[][] obstacleGrid = {
                {0, 0},
                {1, 1},
                {0, 0}
        };

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : 1;
                    continue;
                }
                dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }

        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[1][1]));
    }
}
