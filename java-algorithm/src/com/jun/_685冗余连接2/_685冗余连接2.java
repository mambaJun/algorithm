package com.jun._685冗余连接2;

/**
 * @author Jun
 * @date 2020/9/19 下午6:53
 */
public class _685冗余连接2 {
    // 该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
    /*
        1. 只有 唯一的一个入度 为0的节点，它是根节点
        2. 不是根节点的其他所有节点 入度 都 为 1
        3.不可能存在 入度为 2 的点
     */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        // 边的条数
        int len = edges.length;
        // 1.步骤一：预处理入度数组（记录指向某个节点的边的条数）
        int[] inDegree = new int[len + 1];
        // 统计 每个节点入度 数量
        for (int[] edge : edges) inDegree[edge[1]]++;
        // 2.步骤二：先尝试删除构成入度为 2 的边，看看是否形成环
        for (int i = len - 1; i >= 0; i--) {
            // 如果构不成 环 ，就将这条边删除
            if (inDegree[edges[i][1]] == 2 && judgeCircle(edges, len, i)) return edges[i];
        }
        return new int[2];
    }

    private boolean judgeCircle(int[][] edges, int len, int removeEdgeIndex) {
        UnionFind unionFind = new UnionFind(len + 1);
        for (int i = 0; i < len; i++) {
            if (removeEdgeIndex == i) continue;
            // 如果为 true 说明已经 成环
            if (!unionFind.union(edges[i][0], edges[i][1])) return true;
        }
        // 不成环， 返回 false
        return false;
    }

    private class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                // 隔代压缩
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public boolean union(int x, int y) {
            // 获取根节点
            int rootX = find(x);
            int rootY = find(y);
            // 检查根节点，判断是否在同一个 集合树中
            if (rootX == rootY) return false;
            // 若不在，将两个集合树合并
            parent[x] = rootY;
            return true;
        }
    }
}
