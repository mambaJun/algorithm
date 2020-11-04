package com.jun.算法笔记._1.stack;


/**
 * @author: Jun
 * @date: 2020/7/11 20:34
 */
public class StringLinkedStack {
    private String[] stack;
    private int n;

    public StringLinkedStack(int capacity) {
        stack = new String[capacity];
        n = 0;
    }

    public void push(String item) {
        if (n == stack.length) {
            resize(2 * stack.length);
        }
        stack[n++] = item;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = stack[i];
        }
        stack = copy;
    }

    public String pop() {
        String item = stack[--n];
        stack[n] = null;
        if (n > 0 && n == stack.length / 4) {
            resize(stack.length / 2);
        }
        return item;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return this.n;
    }
}
