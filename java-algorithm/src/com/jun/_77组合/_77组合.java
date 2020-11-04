package com.jun._77组合;

import java.util.*;

/**
 * @author: Jun
 * @date: 2020/9/8 10:31
 */
public class _77组合 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) return res;

        // Deque<Integer> path = new LinkedList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(res, path, n, k, 1);

        return res;
    }

    public void dfs(List<List<Integer>> res, Deque<Integer> path, int n, int k, int begin) {
        int size = path.size();
        // 剪枝
        if (size + (n - begin + 1) < k) return;

        if (size == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {

            path.addLast(i);
            dfs(res, path, n, k, i + 1);
            // 回溯
            path.removeLast();
        }
    }
}
