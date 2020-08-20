package com.jun._207课程表;

import java.util.*;

/**
 * @author Jun
 * @date 2020/8/4 下午10:52
 */
public class _207课程表 {

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

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
// 入度
        int[] indegrees = new int[numCourses];
        // 邻接表
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // 过程队列
        Queue<Integer> queue = new LinkedList<>();

        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        System.out.println(Arrays.toString(indegrees));

        printAdjacency(adjacency);

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.toString());
            int pre = queue.poll();
            numCourses--;
            for (int current : adjacency.get(pre)) {
                if (--indegrees[current] == 0) {
                    queue.add(current);
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
//        for (List<Integer> list : adjacency) {
//            for (Integer num : list) {
//                System.out.printf("%d ", num);
//            }
//            System.out.println();
//        }
    }
}
