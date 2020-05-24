package com.jun.util;

/**
 * @author Jun
 * @date 2020/4/4 上午9:48
 */
public interface Bag<T> {

    /**
     * 添加一个元素
     *
     * @param item
     */
    void add(T item);

    /**
     * 是否为空
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
