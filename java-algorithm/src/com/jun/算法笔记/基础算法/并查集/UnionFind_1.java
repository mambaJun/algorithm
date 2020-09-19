package com.jun.算法笔记.基础算法.并查集;

import java.util.Arrays;

/**
 * @author Jun
 * @date 2020/9/19 下午3:49
 */
public class UnionFind_1 implements BaseUnionFind {
    // 分量 id
    private int[] id;
    // 分量数量
    private int count;

    int num = 0;

    public UnionFind_1(int N) {
        this.count = N;
        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
        }

        print();
        System.out.println("---------- initial ids [] OK");
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        // 已经是在一个 集合中
        if (pId == qId) return;

        // 将 p 的集合命名为 q 的名称
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) id[i] = qId;
        }
        // 集合 数量 减 1
        count--;
    }

    @Override
    public int find(int x) {
        return id[x];
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private void print() {
        System.out.println("第 " + ++num + " 打印 ：" + Arrays.toString(id));
    }

    @Override
    public int count() {
        return this.count;
    }

    public static void main(String[] args) {
        UnionFind_1 unionFind_1 = new UnionFind_1(8);
        System.out.println("-------------- find ----------------");
        for (int i = 0; i < 8; i++) {
            System.out.println(unionFind_1.find(i));
        }

        System.out.println("--------------- union ---------------");
        unionFind_1.union(0, 1);
        unionFind_1.print();

        unionFind_1.union(1, 2);
        unionFind_1.print();

        unionFind_1.union(3, 1);
        unionFind_1.print();

        System.out.println("-------------- find ----------------");
        for (int i = 0; i < 8; i++) {
            System.out.println(unionFind_1.find(i));
        }
    }
}
