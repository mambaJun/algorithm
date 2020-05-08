package com.jun.util;

import java.util.Iterator;

/**
 * @author Jun
 * @date 2020/4/4 上午10:10
 */
public class MyQueue<T> implements Queue<T>, Iterable<T> {


    /**
     * 队头
     */
    private Node first;

    /**
     * 队尾
     */
    private Node last;

    /**
     * 元素数量
     */
    private int N;

    private class Node {

        private T item;
        private MyQueue.Node next;

        public Node(T item, MyQueue.Node next) {
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node(item, null);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    @Override
    public T dequeue() {
        T item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;

        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
