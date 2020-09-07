package com.jun._207课程表;

import java.util.*;

/**
 * @author Jun
 * @date 2020/8/4 下午10:52
 */
public class _207课程表_AOG_BFS {

    public static void main(String[] args) {

        int numCourses = 4;
        int[][] prerequisites = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 3}
        };
        System.out.println(canFinish(numCourses, prerequisites));

    }
    /*
        这道题目是典型的 拓扑排序 的应用题，
        记录每个节点 入度数量，每次从 入度为 0 入队，直到队列为空，如果出队和 总数相同 则符合题目，反之不符合

        利用 队列 进行的广搜

    */

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度统计表 统计 每个节点的入度 数量
        int[] indegrees = new int[numCourses];
        // 构建邻接表 存储每个节点 出度 的节点
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        // 将 图关系 放入 入度统计表 和 邻接表中
        for (int[] prerequisite : prerequisites) {
            // 每个节点的入度 数量
            indegrees[prerequisite[0]]++;
            // 存储每个节点 出度 的节点
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }

        // 将入度为 0 的放入队列，用来 DFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            // 将入度为 0的 节点放入 DFS队列
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            List<Integer> list = adjacency.get(pre);
            for (int index : list) {
                if (--indegrees[index] == 0) {
                    queue.add(index);
                }
            }
        }

        return numCourses == 0;
    }

    private static void printAdjacency(List<List<Integer>> adjacency) {
        for (int i = 0; i < adjacency.size(); i++) {
            System.out.printf("------> i=%d\n", i);
            for (int j = 0; j < adjacency.get(i).size(); j++) {
                System.out.printf("%d ", adjacency.get(i).get(j));
            }
            System.out.println();
        }
    }
}
