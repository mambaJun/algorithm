package com.jun._207课程表;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jun
 * @date 2020/8/4 下午11:32
 */
public class _207课程表_DFS {
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
        // 创建 邻接表
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        // 创建 标记数组
        int[] flags = new int[numCourses];

        // 将 图关系 存入 邻接表
        for (int[] prerequisite : prerequisites) {
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        // 从某个节点进行深搜，如果发现有环 则不符合题意，结束
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency, flags, i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 深搜查找是否有环
     *
     * @param adjacency
     * @param flags
     * @param i
     * @return
     */
    private static boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        // 已经被当前节点 路径 访问，说明有环
        if (flags[i] == 1) return false;
        // 被其他节点启动的 DFS 访问，无需再重复搜索，直接返回 true
        if (flags[i] == -1) return true;

        // 将当前节点标记为 已读
        flags[i] = 1;

        // 从 邻接表中取出 该节点 的入度点
        List<Integer> list = adjacency.get(i);
        for (Integer index : list) {
            if (!dfs(adjacency, flags, index)) {
                return false;
            }
        }
        // 有 回溯算法 的影子，回退上一层
        flags[i] = -1;

        return true;
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
