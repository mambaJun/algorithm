package com.jun.util;

import javax.xml.soap.Node;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author Jun
 * @date 2020/4/4 上午10:17
 */
public class MyBag<T> implements Bag<T>, Iterable<T> {

    private Node first;

    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public void add(T item) {
        Node oldFirst = first;
        first = new Node(item, oldFirst);
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>) new ListIterator();
    }

    private class ListIterator implements Iterable<T> {

        private MyBag.Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {

        }

        public T next() {
            T item = (T) current.item;
            current = current.next;
            return item;
        }

        @Override
        public Iterator<T> iterator() {
            return null;
        }
    }

}
