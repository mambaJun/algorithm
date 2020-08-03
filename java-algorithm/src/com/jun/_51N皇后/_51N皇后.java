package com.jun._51N皇后;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
public class _51N皇后 {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        Deque<Integer> path = new ArrayDeque<>();
        dfs(result, path, 0, n);
        return result;
    }

    /**
     * 深搜 +　回溯 + 剪枝
     *
     * @param result
     * @param path
     * @param index
     * @param n
     */
    private static void dfs(List<List<String>> result, Deque<Integer> path, int index, int n) {
        if (index == n) {
            result.add(pathToResult(path, n));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (path.contains(i)) {
                continue;
            }

            if (isConform(path))
        }


    }

    /**
     * 根据结果下标 转换成 结果集
     *
     * @param path 结果下标
     * @param n
     * @return
     */
    private static List<String> pathToResult(Deque<Integer> path, int n) {
        List<String> result = new ArrayList<>();
        for (Integer index : path) {
            result.add(getResultString(index, n));
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
