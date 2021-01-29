package com.jun.算法笔记.基础算法.并查集;

import java.util.Arrays;

/**
 * @author Jun
 * @date 2020/9/19 下午3:49
 */
public class UnionFind_2 implements BaseUnionFind {
    /*
        在 unionFind_2 中出现了一个 非常影响效率的问题，
        我们知道 树的高度 决定了 访问的树的速度
        每一次 find 都是 从叶子 开始一层层开始 上浮，直至 根节点
        这里给个优化方法：路径压缩
        将 树的高度减小，从而提高树的访问速度
     */

    // 分量 id
    private int[] id;
    // 分量数量
    private int count;

    int num = 0;

    public UnionFind_2(int N) {
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
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        id[pRoot] = qRoot;
        count--;
    }

    @Override
    public int find(int x) {
        while (x != id[x]) {
            x = id[x];
        }
        return x;
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
        UnionFind_2 unionFind_2 = new UnionFind_2(8);
        System.out.println("-------------- find ----------------");
        for (int i = 0; i < 8; i++) {
            System.out.println(unionFind_2.find(i));
        }

        System.out.println("--------------- union ---------------");
        unionFind_2.union(0, 1);
        unionFind_2.print();

        unionFind_2.union(1, 2);
        unionFind_2.print();

        unionFind_2.union(3, 1);
        unionFind_2.print();

    }
}
