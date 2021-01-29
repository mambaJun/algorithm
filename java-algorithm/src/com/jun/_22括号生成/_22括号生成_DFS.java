package com.jun._22括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jun
 * @date 2020/7/31 上午9:25
 */
public class _22括号生成_DFS {
    public static void main(String[] args) {

        System.out.println(generateParenthesis(3).toString());
    }
    /*
        https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
        方法总结：
            1、深度优先遍历 + 剪枝 下面链接是 演示图
            https://pic.leetcode-cn.com/7ec04f84e936e95782aba26c4663c5fe7aaf94a2a80986a97d81574467b0c513-LeetCode%20%E7%AC%AC%2022%20%E9%A2%98%EF%BC%9A%E2%80%9C%E6%8B%AC%E5%8F%B7%E7%94%9F%E5%87%BA%E2%80%9D%E9%A2%98%E8%A7%A3%E9%85%8D%E5%9B%BE.png
            2、回溯法
            在 dfs 中的第一个 if 可以看出 回溯的表现
    */

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(list, "", 0, 0, n);
        return list;
    }

    /**
     * @param list  结果集
     * @param str   当前值
     * @param left  左括号数量
     * @param right 右括号数量
     * @param n     括号数量
     */
    private static void dfs(List<String> list, String str, int left, int right, int n) {
        // 出口
        // 约定的条件
        // 当 左或右 超出条件
        // 右括号 数量 > 左括号数量（使结果不成立，  剪枝  ）
        if (left > n || right > n || right > left) return;

        if (left == n && right == n) {
            // 左右括号符合条件 ，放入结果集，到达树叶子节点处，并返回
            list.add(str);
            return;
        }

        dfs(list, str + "(", left + 1, right, n);
        dfs(list, str + ")", left, right + 1, n);
    }
}
