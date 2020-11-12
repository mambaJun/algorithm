package com.jun.最小生成树;

import java.util.Arrays;

/**
 * Prim 算法 使用了贪心的思想
 * dist[j] = Math.min(dist[j], w[t][j]);
 *
 * @author Jun
 * @date 2020/11/9 下午5:43
 */
public class Prim {
    static int n = 6;
    static int[][] w = new int[n][n];
    // 每个点距离树的距离, 刚开始　全都设置为　无穷，后面一步步更新　每个节点　距离　生成树的　距离
    static int[] dist = new int[n];
    static boolean[] used = new boolean[n];

    private static int prim() {
        int res = 0;

        // 初始化  每个点 和 最小树的距离为 无穷
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 第一个点 为 0，选为 树的点
        dist[0] = 0;

        // 遍历每个点
        for (int i = 0; i < n; i++) {
            // 当前点
            int t = -1;
            for (int j = 0; j < n; j++) {
                if (!used[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }

            res += dist[t];
            used[t] = true;

            for (int j = 0; j < n; j++) {
                dist[j] = Math.min(dist[j], w[t][j]);
            }
        }
        return res;
    }

    private static void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    w[i][j] = 0;
                    continue;
                }
                if (i < j) {
                    int tmp = 0;
                    while (tmp == 0) {
                        tmp = (int) (Math.random() * 1000 / 123);
                    }
                    w[i][j] = tmp;
                    continue;
                }
                w[i][j] = w[j][i];
            }
        }
    }

    public static void main(String[] args) {
        init();
        print();

//        System.out.println(prim());
        System.out.println(prim1());
    }

    private static int prim2() {
        int res = 0;

        // 初始化  每个点 和 最小树的距离为 无穷
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 第一个点 为 0，选为 树的点
        dist[0] = 0;

        // 遍历每个点
        for (int i = 0; i < n; i++) {
            // 当前点
            int t = -1;
            for (int j = 0; j < n; j++) {
                if (!used[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }

            res += dist[t];
            used[t] = true;

            for (int j = 0; j < n; j++) {
                dist[j] = Math.min(dist[j], w[t][j]);
            }
        }
        return res;
    }

    private static int prim1() {
        //　将距离数组　设置为　无穷
        Arrays.fill(dist, Integer.MAX_VALUE);
        //　随便选择一个点作为　起始点，这里选择　第一个点
        dist[0] = 0;
        // 生成最小树　过程中，最小权值
        int res = 0;
        //　遍历所有的点，组成最小树，每走一步，就是增加一个节点
        for (int i = 0; i < n; i++) {
            int tmp = -1;
            for (int j = 0; j < n; j++) {
                // 当前 节点未 使用，
                if (!used[j] && (tmp == -1 || dist[tmp] > dist[j])) {
                    tmp = j;
                }
            }

            res += dist[tmp];
            used[tmp] = true;

            // 更新　距离表　每个点距离树的距离
            for (int j = 0; j < n; j++) {
                dist[j] = Math.min(dist[j], w[tmp][j]);
            }
        }
        return res;
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", w[i][j]);
            }
            System.out.println();
        }
    }
}
