package com.jun._684冗余连接;

import java.util.Arrays;

/**
 * @author Jun
 * @date 2020/9/19 下午4:57
 */
public class _684冗余连接 {
    /*
        并查集 算法

     */
    private int[] parents;

    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];

        if (edges == null || edges.length == 0) return res;
        init(edges.length + 1);
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            // 第二次 出现联通时，表示已经找到了
            if (!union(x,y)) return edge;
        }

        return res;
    }

    /**
     * 第一次 x 和 y 不联通时，设置成联通关系，返回 true
     * 第二次 x 和 y 联通时， 返回 false
     *
     * @param x
     * @param y
     * @return
     */
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return false;

        parents[rootX] = rootY;
        return true;
    }

    /**
     * 路径压缩，找到 x 的根节点
     *
     * @param x
     * @return
     */
    private int find(int x) {
        if (x != parents[x]) {
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    /**
     * 初始化 parents
     *
     * @param n
     */
    private void init(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public static void main(String[] args) {
        int[][] edges = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 4},
                {1, 5}
        };
        _684冗余连接 main = new _684冗余连接();
        int[] res = main.findRedundantConnection(edges);
        System.out.println(Arrays.toString(res));
    }
}
