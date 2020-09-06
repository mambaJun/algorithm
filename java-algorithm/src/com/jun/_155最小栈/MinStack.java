package com.jun._155最小栈;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 *
 * @author Jun
 * @date 2020/4/1 上午10:31
 */
public class MinStack {

    private class Node {
        int val;
        // 精髓在这个地方，可以记住当前状态下的 min
        int min;
        Node next;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;


    /**
     * initialize your data structure here.
     */
    public MinStack() {
    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
            return;
        }

        int min = Math.min(x, head.min);
        // 精髓在这个地方，可以记住当前状态下的 min
        Node node = new Node(x, min, head);
        head = node;
    }

    public void pop() {
        if (head == null) {
            return;
        }
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}
