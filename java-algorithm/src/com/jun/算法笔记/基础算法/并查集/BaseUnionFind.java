package com.jun.算法笔记.基础算法.并查集;

/**
 * @author Jun
 * @date 2020/9/19 下午3:47
 */
public interface BaseUnionFind {

    /**
     * 在 p 和 q 之间加一条 连接
     *
     * @param p
     * @param q
     */
    void union(int p, int q);

    /**
     * p [0, n-1] 所在的 集合树 根
     *
     * @param x
     * @return
     */
    int find(int x);

    /**
     * 如果 p 和 q 在同一个集合中，返回 true
     *
     * @param p
     * @param q
     * @return
     */
    boolean connected(int p, int q);

    /**
     * 连通分量 的数量
     *
     * @return
     */
    int count();
}
