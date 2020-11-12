package com.jun.最小生成树;

import java.util.Arrays;

/**
 * @author Jun
 * @date 2020/11/9 下午5:43
 */
public class Kruskal {

    public static void main(String[] args) {
        int n = 5;
        Kruskal kruskal = new Kruskal(n);
        kruskal.addEdge(0, 1, 8);
        kruskal.addEdge(0, 2, 1);
        kruskal.addEdge(0, 4, 3);
        kruskal.addEdge(1, 3, 5);
        kruskal.addEdge(2, 3, 2);
        System.out.println(kruskal.kruskal());
    }

    private Edge[] edges;
    int[] parent;
    int count;
    int n;
    int index = 0;

    public Kruskal(int n) {
        this.n = n;
        this.edges = new Edge[n];
        this.parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        this.count = n;
    }

    public int kruskal() {
        Arrays.sort(edges, (v1, v2) -> v1.w - v2.w);
        int res = 0;
        for (int i = 0; i < n; i++) {
            Edge edge = edges[i];
            int a = edge.a;
            int b = edge.b;
            int w = edge.w;

            if (!connected(a, b)) {
                union(a, b);
                res += w;
            }
        }

        System.out.println(Arrays.toString(parent));
        return res;
    }

    public void addEdge(int a, int b, int w) {
        edges[index++] = new Edge(a, b, w);
    }

    int find(int x) {
        if (parent[x] == x) {
            return x;
        }
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
        count--;
    }

    int count() {
        return count;
    }

    private class Edge {
        int a;
        int b;
        int w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
}
