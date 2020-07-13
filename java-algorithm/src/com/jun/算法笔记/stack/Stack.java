package com.jun.算法笔记.stack;

/**
 * @author: Jun
 * @date: 2020/7/11 19:34
 */
public class Stack<T> implements StackInterface<T> {
    /**
     * 有头链表
     */
    private Node<T> head;
    private int size;

    public Stack() {
        this.head = new Node<T>();
        head.next = null;
        head.item = null;

        size = 0;
    }


    @Override
    public void push(T item) {
        // 创建 新节点
        Node<T> newNode = new Node<>();
        newNode.item = item;
        newNode.next = head;

        head = newNode;
        size++;
    }

    @Override
    public T pop() {
        if (head.next == null || size <= 0) {
            return null;
        }
        Node<T> oldNode = head;
        head = head.next;

        // Java中的指针是否具有传递性
        System.out.println(oldNode.hashCode() == head.hashCode());

        size--;

        return oldNode.item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {

    }

    /**
     * 以内部类的形式 表示节点
     */
    private class Node<T> {
        T item;
        Node next;
    }
}
