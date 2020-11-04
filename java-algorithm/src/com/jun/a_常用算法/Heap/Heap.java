package com.jun.a_常用算法.Heap;

/**
 * @author: Jun
 * @date: 2020/10/2 10:49
 */
public class Heap {
    /*
        完全二叉树的性质：
            一维数组的 存储:
                当前节点：x
                左节点：2 * x
                右节点：2 * x + 1
        样例：
            节点集合：1 2 3 4 5 6 7
                          1
                    2           3
                4       5   6       7

                1 2 3 4 5 6 7


     */
    // 建 小根堆
    int[] heap = new int[10];
    int size = 0;

    private void down(int u) {
        // t 是用来记录 最小值
        int t = u;
        // 存在左子节点       左子节点 小于 当前节点
        if (u * 2 <= size && heap[u * 2] < heap[t]) {
            t = u * 2;
        }
        // 存在右子节点       右子节点 小于 当前节点
        if (u * 2 + 1 <= size && heap[u * 2 + 1] < heap[t]) {
            t = u * 2 + 1;
        }
        // 如果 当前节点不是 最小节点 ，递归继续 下沉
        if (u != t) {
            swap(heap, u, t);
            down(t);
        }
    }

    private void up(int u) {
        // 存在根节点        根节点 比 本身大
        while (u / 2 != 0 && heap[u / 2] > heap[u]) {
            // 上浮
            swap(heap, u / 2, u);
            u /= 2;
        }
    }

    private void swap(int[] heap, int u, int t) {
        int tmp = heap[u];
        heap[u] = heap[t];
        heap[t] = tmp;
    }

    public static void main(String[] args) {
        System.out.println((-10 % 3 + 3) % 3);

    }

}
