package com.jun.算法笔记._1.stack;

/**
 * @author: Jun
 * @date: 2020/7/11 21:43
 */
public class ArrayLinkedStack<T> implements StackInterface<T> {

    private T[] list;
    private int size;

    public ArrayLinkedStack(int capacity) {
        list = (T[]) new Object[capacity];

    }

    public static void main(String[] args) {
        ArrayLinkedStack<String> stack = new ArrayLinkedStack<>(16);

    }

    @Override
    public void push(T item) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}