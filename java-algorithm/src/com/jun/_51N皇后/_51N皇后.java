package com.jun._51N皇后;

import java.util.*;

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
public class _51N皇后 {
    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        outputResult(lists);
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        // 下标索引当做行数 值当做列数 初始值全为 -1
        int[] columns = new int[n];

        Arrays.fill(columns, -1);
        dfs(result, columns, 0, n);

        return result;
    }

    /**
     * 深搜 +　回溯 + 剪枝
     * @param result    存放结果的结果集
     * @param columns   一轮结果的存放 路径
     * @param row       当前是第几行
     * @param n         一共多少行
     */
    private static void dfs(List<List<String>> result, int[] columns, int row, int n) {
        if (row == n) {
            result.add(new ArrayList<>(pathToResult(columns)));
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
            dfs(result, columns, row + 1, n);
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
     * 根据结果下标 转换成 结果集
     *
     * @return
     */
    private static List<String> pathToResult(int[] columns) {
        List<String> result = new ArrayList<>();
        if (columns.length == 0) {
            return result;
        }
        for (int i = 0; i < columns.length; i++) {
            result.add(getResultString(columns[i], columns.length));
        }
        return result;
    }

    /**
     * 根据 index 生成 ..Q.
     *
     * @param index Q位置
     * @param n     字符串 长度
     * @return
     */
    private static String getResultString(Integer index, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(i == index ? "Q" : ".");
        }
        return builder.toString();
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
