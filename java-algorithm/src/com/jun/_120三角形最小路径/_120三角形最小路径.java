package com.jun._120三角形最小路径;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/5/17 下午11:25
 */
public class _120三角形最小路径 {
    public static int minimumTotal(List<List<Integer>> triangle) {

        int column = triangle.size();
        int row = triangle.get(column - 1).size();
        int[][] dp = new int[row][column];
/*
相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
现在的相邻接点找错了,按照这个定义来改
*/
        for (int c = 0; c < column; c++) {
            for (int r = 0; r < triangle.get(c).size(); r++) {
//                System.out.println(r + " - " + c);
                // 第一行
                if (c == 0) {
                    dp[r][c] = triangle.get(r).get(c);
                    break;
                }
                int lastColumnSize = c - 1;
                int lastRowSize = triangle.get(lastColumnSize).size() - 1;
                Integer currentValue = triangle.get(c).get(r);
                // 每一行的第一个
                if (r == 0) {
                    dp[r][c] = dp[lastRowSize][lastColumnSize] + currentValue;
                    continue;
                }
                dp[r][c] = Math.min(dp[r - 1][c], dp[lastRowSize][lastColumnSize] + currentValue);
            }
        }

        return dp[row - 1][column - 1];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
//        triangle.add(Arrays.asList(2));
//        triangle.add(Arrays.asList(3, 4));
//        triangle.add(Arrays.asList(6, 5, 7));
//        triangle.add(Arrays.asList(4, 1, 8, 3));
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(1, -1, -3));
        System.out.println(minimumTotal(triangle));
    }
}
