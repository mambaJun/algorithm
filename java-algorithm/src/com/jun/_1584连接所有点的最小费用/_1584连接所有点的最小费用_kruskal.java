package com.jun._1584连接所有点的最小费用;

import java.util.Arrays;

/**
 * @author Jun
 * @date 2020/11/9 下午9:05
 */
public class _1584连接所有点的最小费用_kruskal {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        int[][] points = {{-1000000, -1000000}, {1000000, 1000000}};
        System.out.println(solution.minCostConnectPoints(points));
    }
}

class Solution {
    int[] parent;
    // 边的真实个数
    int count = 0;
    Edge[] edges;

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int len = n * (n - 1) / 2;

        if (len == 1) {
            return val(points[0][0], points[0][1], points[1][0], points[1][1]);
        }
        parent = new int[n * (n - 1) / 2];

        for (int i = 0; i < len; i++) {
            parent[i] = i;
        }

        edges = new Edge[len];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                addEdge(i, j, val(points[i][0], points[i][1], points[j][0], points[j][1]));
            }
        }

        Arrays.sort(edges, (v1, v2) -> v1.w - v2.w);

        int res = 0;

        for (int i = 0; i < len; i++) {
            Edge edge = edges[i];
            int a = edge.a;
            int b = edge.b;
            int w = edge.w;

            if (!connected(a, b)) {
                union(a, b);
                res += w;
            }
        }

        return res;
    }

    int val(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        parent[pRoot] = qRoot;
    }

    void addEdge(int a, int b, int w) {
        if (count == parent.length) return;
        edges[count++] = new Edge(a, b, w);
    }

    class Edge {
        int a;
        int b;
        int w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public String toString() {
            return a + " " + b + " " + w + "\n";
        }
    }
}