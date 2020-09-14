package com.jun.算法笔记._1.stack;

/**
 * @author: Jun
 * @date: 2020/7/11 20:10
 */
public class LinkedStack<T> implements StackInterface<T>{

    public static void main(String[] args) {
        LinkedStack<String> stringLinkedStack = new LinkedStack<>();

    }

    private Node<T> first = null;
    private int size;

    @Override
    public void push(T item) {
        Node<T> oldNode = first;
        first = new Node<>();
        first.item = item;
        first.next = oldNode;
        size++;
    }

    @Override
    public T pop() {
        // 这里的 判空可以不要
        if (first == null) {
            return null;
        }

        T item = first.item;
        first = first.next;
        size--;

        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 以内部类的形式 表示节点
     */
    private class Node<T> {
        T item;
        Node next;
    }
}
