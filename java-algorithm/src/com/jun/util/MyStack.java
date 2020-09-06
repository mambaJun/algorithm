package com.jun.util;

import java.util.Iterator;

/**
 * @author Jun
 * @date 2020/4/4 上午10:02
 */
public class MyStack<T> implements Stack<T>, Iterable<T> {

    private Node first;
    private int N;

    private class Node {

        private T item;
        private Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }


    @Override
    public void push(T item) {
        Node oldFirst = first;
        first = new Node(item, oldFirst);
        N++;
    }

    @Override
    public T pop() {
        T item = first.item;
        first = first.next;
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
