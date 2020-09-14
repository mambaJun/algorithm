package com.jun.util;

/**
 * @author Jun
 * @date 2020/4/4 上午9:51
 */
public interface Stack<T> {
    /**
     * 添加一个元素
     *
     * @param item
     */
    void push(T item);

    /**
     * 删除最近添加的元素（出栈）
     *
     * @return
     */
    T pop();

    /**
     * 判空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 元素数量
     *
     * @return
     */
    int size();
}
