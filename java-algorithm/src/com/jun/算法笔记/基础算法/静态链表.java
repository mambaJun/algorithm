package com.jun.算法笔记.基础算法;

import java.util.Arrays;

/**
 * @author Jun
 * @date 2020/9/15 下午8:24
 */
public class 静态链表 {
    /*
        用 静态数组 来 模拟 链表
        这里 规定 -1 代表 null

       E h -> 1 -> 2 -> 3 -> 4 -> 5
       NE     0    1    2    3    4

    */
    static int N = 10;             // 开辟 长度为 10 的数组，来模拟 链表
    static int[] E = new int[N];   // 链表的 val  E[i] 节点 i 的值是多少
    static int[] NE = new int[N];  // 链表的 next 指针  NE[i] 节点 i 的next指针是多少
    static int head;               // 表示头结点的下标 位置
    static int index;              // 记录 当前已经用到了哪个点

    public static void initial() {
        System.out.println("----->>> initial");
        head = -1;  // 每一个节点都没有被分配，所以取值为 -1
        index = 0;  // 当前可以从 0 号点开始用
        print();
    }

    // 将 下标k 后面的一个节点删除
    public static void remove(int k) {
        System.out.println("----->>> remove");
        NE[k] = NE[NE[k + 1]];
        print();
    }

    // 在 头结点 后面 添加 一个节点
    public static void addToHead(int x) {
        System.out.println("----->>> add to head");
        E[index] = x;
        NE[index] = head;
        head = index;
        index++;
        print();
    }

    // 将 x 插入 到 下标 是 k 的后面
    public static void addNodeToK(int k, int x) {
        System.out.println("----->>> add to k behind");
        E[index] = x;       // 节点 赋值
        NE[index] = NE[k];  // 新节点 next 指向 上一个节点的 next
        NE[k] = index;      // 上一个 节点 next 指向 新节点 下标
        index++;            // 当前已用节点 位置 +1
        print();
    }

    static void print() {
        System.out.println("E ----->>> " + Arrays.toString(E));
        System.out.println("NE ---->>> " + Arrays.toString(NE));
        System.out.println("head--->>> " + head);
        System.out.println("index-->>> " + index);
    }

    public static void main(String[] args) {
        initial();
        addToHead(1);
        addToHead(2);
        addToHead(3);
        addToHead(3);
        addNodeToK(0, 10);
        addNodeToK(0, 10);
        remove(3);

    }
}
