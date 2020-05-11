package com.jun._62不同路径;

import com.jun.util.ArrayUtil;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10 ^ 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/5/10 下午10:59
 */
public class _62不同路径_递归版 {


    public static int uniquePaths(int m, int n) {
        int[][] arr = new int[m + 1][n + 1];
        arr[0][0] = 1;
        return paths(arr, m, n);

    }

    private static int paths(int[][] arr, int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        if (arr[m][n] > 0) {
            return arr[m][n];
        }

        if (m == 1 || n == 1) {
            return 1;
        }

        arr[m - 1][n] += uniquePaths(m - 1, n);
        arr[m][n - 1] += uniquePaths(m, n - 1);
        arr[m][n] = arr[m - 1][n] + arr[m][n - 1];
        return arr[m][n];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7, 3));
    }
}
