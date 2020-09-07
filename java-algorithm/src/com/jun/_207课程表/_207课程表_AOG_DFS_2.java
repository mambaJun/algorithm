package com.jun._207课程表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jun
 * @date 2020/8/4 下午10:52
 */
public class _207课程表_AOG_DFS_2 {

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

    private static List<List<Integer>> edges;
    private static int[] visited;
    boolean valid = true;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 创建邻接表
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];

        return true;
    }
}
