package com.jun._51N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/8/3 下午10:53
 */
public class _52N皇后2 {
    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }

    private static int count = 0;

    public static int totalNQueens(int n) {

        // 下标索引当做行数 值当做列数 初始值全为 -1
        int[] columns = new int[n];

        Arrays.fill(columns, -1);
        dfs(columns, 0, n);

        return count;
    }

    /**
     * 深搜 +　回溯 + 剪枝
     *
     * @param columns 一轮结果的存放 路径
     * @param row     当前是第几行
     * @param n       一共多少行
     */
    private static void dfs(int[] columns, int row, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int i = 0; i < n; i++) {
            // 检查对角线和同列 不符合跳过
            if (isConform(columns, row, i)) {
                continue;
            }
            // 更新当前行 列的位置
            columns[row] = i;
            // 下一行进行深搜
            dfs(columns, row + 1, n);
            // 回溯 回退当前行 的状态到 看作未曾到
            columns[row] = -1;

        }
    }

    private static boolean isConform(int[] columns, int row, int column) {
        for (int i = 0; i < row; i++) {
            // 对角线      行-行                 列-列
            if (Math.abs(i - row) == Math.abs(columns[i] - column)) {
                return true;
            }
            // 列 查找
            if (columns[i] == column) {
                return true;
            }
        }
        return false;
    }

    /**
     * 输出结果
     *
     * @param result
     */
    private static void outputResult(List<List<String>> result) {
        for (List<String> list : result) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("-----------------------");
        }
    }

}
