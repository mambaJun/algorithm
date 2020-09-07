package com.jun._22括号生成;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jun
 * @date 2020/7/31 上午9:25
 */
public class _22括号生成_dp {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3).toString());
    }

    private static class Node {
        private String str;
        private int left;
        private int right;

        public Node(String str, int left, int right) {
            this.str = str;
            this.left = left;
            this.right = right;
        }
    }

    /*
        广度优先搜索（BFS）
        BFS 是借助 队列，入队 然后出队 将子节点存入，实现 树的 层级遍历

    */

    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        // 结果集 dp 数组
        List<List<String>> dp = new ArrayList<>(n);
        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 0; i <= n; i++) {
            List<String> current = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);

            }
        }
        return dp.get(n);
    }
}
