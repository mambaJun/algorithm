package com.jun._310最小高度树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 * <p>
 * 格式
 * <p>
 * 该图包含 n 个节点，标记为 0 到 n - 1。给定数字 n 和一个无向边 edges 列表（每一个边都是一对标签）。
 * <p>
 * 你可以假设没有重复的边会出现在 edges 中。由于所有的边都是无向边， [0, 1]和 [1, 0] 是相同的，因此不会同时出现在 edges 里。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * <p>
 * 0
 * |
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: [1]
 * 示例 2:
 * <p>
 * 输入: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * <p>
 * 0  1  2
 * \ | /
 * 3
 * |
 * 4
 * |
 * 5
 * <p>
 * 输出: [3, 4]
 * 说明:
 * <p>
 *  根据树的定义，树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * 树的高度是指根节点和叶子节点之间最长向下路径上边的数量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/10/11 下午12:10
 */
public class _310最小高度树 {
    public static void main(String[] args) {
//        int n = 4;
//        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};

        int n = 6;
        int[][] edges = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        System.out.println(findMinHeightTrees(n, edges).toString());
    }

    /*
    想先说一下，第一个思路，也是最容易想到的方法
       1、 n 有 [0，n - 1]个点，将每个点看作根节点，每个根节点来一遍 BFS，将得到 最小高度的集合 返回
    参考 别人的写法，实现第二种
       2、自外向内的 方式。可以看作剥洋葱，剥到最后就是结果
        剥洋葱的方法 是 将 无向图，全部看作有向图进行处理，从而可以准确的确定每一层的节点

     对比感悟：
        法1 是自顶向下的 思路，法2 是自下而上的 思路
        在这个题目中，采用自顶向下需要 n次， 但是 采用 自下而上只需要 n次 就可以得到答案，所以 平时做题的过程中，两种思路都最好实现一遍

     */
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {

        //  自外向内的 方式，每次的 res 代表了 ，当前 层的节点数量， 直到最后一层，说明是最小高度树的 集合
        List<Integer> res = null;
        if (n == 1) {
            res = new ArrayList<>();
            res.add(0);
            return res;
        }


        // 创建 邻接表
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // 入度 数组
        int[] indegree = new int[n];

        // 存储 图关系
        for (int[] edge : edges) {
            indegree[edge[0]]++;
            indegree[edge[1]]++;
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        // 将 最外层的节点（入度为 1的节点）入队，此后每次入队的都是 当前意义上地叶子节点，
        for (int i = 0; i < n; i++) {
            if (indegree[i]-- == 1) queue.offer(i);
        }

        // 经典的 BFS，写法
        while (!queue.isEmpty()) {
            // 每一层 的节点集
            res = new ArrayList<>();
            // 经典的 BFS，写法
            int size = queue.size();
            while (size-- > 0) {
                int currentNode = queue.poll();
                // 将当前节点 放入 当前层 集合中
                res.add(currentNode);
                // 获取 当前节点的 相邻节点，处理 他们的入度，如果是 1 也就是 叶子节点， 入队
                List<Integer> neighbor = adj.get(currentNode);
                for (Integer node : neighbor) {
                    // 入度，如果是 1 也就是 叶子节点， 入队
                    if (indegree[node]-- == 1) queue.offer(node);
                }
            }
        }

        return res;
    }
}
