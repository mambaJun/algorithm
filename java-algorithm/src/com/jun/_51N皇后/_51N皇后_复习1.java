package com.jun._51N皇后;

import java.util.*;

/**
 * n皇后问题研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的n皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
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
public class _51N皇后_复习1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(4);
        printResult(lists);
    }

    private static void printResult(List<List<String>> lists) {
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("---------------------------------");
        }
    }
}

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(0, n, new int[n], res);
        return res;
    }

    private void dfs(int k, int n, int[] path, List<List<String>> res) {
        if (k == n) {
            res.add(pathToList(path, n));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!check(k, i, path)) continue;
            path[k] = i + 1;
            dfs(k + 1, n, path, res);
            path[k] = 0;
        }
    }

    private List<String> pathToList(int[] path, int n) {
        List<String> res = new ArrayList<>();

        for (int row = 0; row < n; row++) {
            StringBuilder builder = new StringBuilder();
            for (int col = 0; col < n; col++) {
                builder.append(path[row] == col + 1 ? "Q" : ".");
            }
            res.add(builder.toString());
        }
        return res;
    }

    /**
     * 判断 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击
     *
     * @return
     */
    private boolean check(int x, int y, int[] path) {
        // 纵向
        for (int i = 0; i < x; i++) {
            if (path[i] == y + 1) return false;
        }
        // 对角线
        for (int i = 0; i < x; i++) {
            int row = i;
            int col = path[i] - 1;
            if (Math.abs(x - row) == Math.abs(y - col)) return false;
        }
        return true;
    }
}
