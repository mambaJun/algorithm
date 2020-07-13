package com.jun.算法笔记.queue;

/**
 * @author: Jun
 * @date: 2020/7/11 21:17
 */
public class QueueOfString {
    private Node first;
    private Node last;
    private int n;

    public QueueOfString() {

    }

    /**
     * 始终更新 last
     *
     * @param item
     */
    void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }


    String dequeue() {
        String item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        n--;
        return item;
    }

    boolean isEmpty() {
        return first == last;
    }

    int size() {
        return n;
    }


    /**
     * 以内部类的形式 表示节点
     */
    private class Node {
        String item;
        Node next;
    }
}
