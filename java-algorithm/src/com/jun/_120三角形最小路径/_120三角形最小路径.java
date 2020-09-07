package com.jun._120三角形最小路径;

import com.jun.util.ArrayUtil;

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

    /**
     * 动态规划:
     * 优化
     * 创建一个一维数组
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (!isValid(triangle)) {
            return 0;
        }

        int column = triangle.size();
        int row = triangle.get(column - 1).size();

        int[] dp = new int[row];
        dp[0] = triangle.get(0).get(0);

        int pre = 0;
        int curr = 0;
        for (int c = 1; c < column; c++) {
            List<Integer> rows = triangle.get(c);
            for (int r = 0; r < rows.get(c); r++) {
                int value = rows.get(r);
                curr = dp[r];
                if (r == 0) {
                    dp[r] = curr + rows.get(r);
                } else if (r == c) {
                    dp[r] = pre + rows.get(r);
                } else {
                    dp[r] = Math.min(pre, curr) + value;
                }
                pre = curr;
            }
        }

        return getMin(dp);
    }

    /**
     * 动态规划:
     * 创建一个二维数组,同样创建一个类型这个一样的下三角形,自顶向下,数组的每个位置代表它的最小值,这样最下方的一层就是最终结果,只要从最后一行找出最小值即可
     *
     * @param triangle
     * @return
     */
    public static int minimumTotal_old(List<List<Integer>> triangle) {
        if (!isValid(triangle)) {
            return 0;
        }

        int column = triangle.size();
        int row = triangle.get(column - 1).size();
        int[][] dp = new int[row][column];
        dp[0][0] = triangle.get(0).get(0);

        for (int c = 1; c < column; c++) {
            List<Integer> integers = triangle.get(c);
            for (int r = 0; r < integers.size(); r++) {
                int value = integers.get(r);
                if (r == 0) {
                    dp[r][c] = dp[r][c - 1] + value;
                    continue;
                }
                if (r == c) {
                    dp[r][c] = dp[r - 1][c - 1] + value;
                    continue;
                }
                dp[r][c] = Math.min(dp[r][c - 1], dp[r - 1][c - 1]) + value;
            }
        }

        return getMin(dp[column - 1]);
    }

    private static boolean isValid(List<List<Integer>> triangle) {
        return triangle != null || triangle.size() > 0;
    }

    private static int getMin(int[] dp) {
        int min = dp[0];
        for (int i = 0; i < dp.length; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
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
        System.out.println(minimumTotal_old(triangle));
    }
}
