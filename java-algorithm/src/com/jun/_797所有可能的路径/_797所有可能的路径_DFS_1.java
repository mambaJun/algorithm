package com.jun._797所有可能的路径;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jun
 * @date 2020/10/7 下午8:29
 */
public class _797所有可能的路径_DFS_1 {

    public static void main(String[] args) {
        int[][] graph = {
                {1, 2},
                {3},
                {3},
                {}
        };
        List<List<Integer>> lists = allPathsSourceTarget(graph);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.printf("%d ", integer);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return slove(graph, 0);
    }

    private static List<List<Integer>> slove(int[][] graph, int node) {
        int n = graph.length;

        List<List<Integer>> res = new ArrayList<>();

        if (node == n - 1) {
            List<Integer> path = new ArrayList<>();
            path.add(node);
            res.add(path);
            return res;
        }

        for (int nei : graph[node]) {
            for (List<Integer> path : slove(graph, nei)) {
                path.add(0, node);
                res.add(path);
            }
        }

        return res;
    }

}
