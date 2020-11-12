package com.jun.最短路径;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Dijkstra {
}

class Solution {
    static int INFINITY = 0x40;
    static int n;
    static int[][] g;
    static int[] dist;
    static boolean[] mark;
    static int begin = 0;
    static int end = 0;
    public static void main(String[] args) {
        // 一共多少个节点
        n = 3;
        // 邻接矩阵
        g = new int[n][n];
        // 每个 节点 距离 初始化节点的距离
        dist = new int[n];
        // 标记每个节点是否已经再 路线上了
        mark = new boolean[n];
        begin = 0;
        end = n - 1;
        init();
        System.out.println(dijkstra());
    }
    static int dijkstra() {
        // 将 每个点都是初始化成 初始化节点的距离 为 无穷
        Arrays.fill(dist, INFINITY);
        // begin 是 起始点, 初始化 起始点 距离路线的距离 为 0
        dist[begin] = 0;
        for (int i = 0; i < n; i++) {
            int index = -1;
            for (int j = 0; j < n; j++) {
                // 未标记 并且 （未比较 或者 当前的记录的节点不是最小 值）
                if (!mark[j] && (index == -1 || dist[index] > dist[j])) {
                    index = j;
                }
                // 如果已经到达终点， 可以直接返回，进行优化
                if (index == end) return dist[end];
            }
            // 标记 该点 入路线
            mark[index] = true;
            // 更新 每个点距离 起始点的 最小距离
            for (int j = 0; j < n; j++) {
                dist[j] = Math.min(dist[j], dist[index] + g[index][j]);
            }
        }
        return dist[end] == INFINITY ? -1 : dist[end];
    }
    static void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = i == j ? 0 : INFINITY;
            }
        }
        g[0][1] = 2;
        g[1][2] = 1;
        g[0][2] = 4;
        print();
    }
    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d\t", g[i][j]);
            }
            System.out.println();
        }
    }
}
