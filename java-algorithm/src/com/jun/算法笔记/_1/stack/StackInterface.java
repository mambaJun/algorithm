package com.jun.算法笔记._1.stack;

/**
 * 定义 Stack 的基本接口
 *
 * @author: Jun
 * @date: 2020/7/11 19:45
 */
public interface StackInterface<T> {
    public void push(T item);

    public T pop();

    public boolean isEmpty();

    public int size();
}
