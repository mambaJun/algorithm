package com.jun.util;

/**
 * @author Jun
 * @date 2020/4/4 上午9:50
 */
public interface Queue<T> {
    /**
     * 添加一个元素
     *
     * @param item
     */
    void enqueue(T item);

    /**
     * 删除最早添加的元素（队头）
     *
     * @return
     */
    T dequeue();

    /**
     * 队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 队列元素个数
     *
     * @return
     */
    int size();
}
