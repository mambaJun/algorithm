package com.jun._797所有可能的路径;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jun
 * @date 2020/10/7 下午9:01
 */
public class _797所有可能的路径_DFS_2 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();

        Deque<Integer> path = new LinkedList<>();
        path.add(0);
        slove(graph, 0, res, path);

        return res;
    }

    private void slove(int[][] graph, int node, List<List<Integer>> res, Deque<Integer> path) {
        int n = graph.length;
        if (node == n - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        int[] nei = graph[node];
        for (int i = 0; i < nei.length; i++) {
            path.addLast(nei[i]);

            slove(graph, nei[i], res, path);

            path.removeLast();
        }
    }
}
