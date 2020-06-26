package com.jun._203移除链表元素_203;

import java.util.Arrays;
import java.util.List;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author Jun
 * @date 2020/1/31 下午4:13
 */
public class 移除链表元素_203 {
    public static void main(String[] args) {
        ListNode head = createList(Arrays.asList(1, 2, 3, 4, 5, 5));
        System.out.println("create list");
        outputList(head);
        System.out.println("remove node");
        removeElements(head, 5);
        outputList(head);
    }

    /**
     * 递归
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        System.out.println(head.next);
        return head.val == val ? head.next : head;
    }

    /**
     * 创建无头链表
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements2(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode pre = head;

        if (pre != null) {
            while (pre.next != null) {
                if (pre.next.val == val) {
                    pre.next = pre.next.next;
                } else {
                    pre = pre.next;
                }
            }
        }

        return head;
    }

    /**
     * 创建有头链表
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements1(ListNode head, int val) {
        // 创建头节点，构造成有头链表
        ListNode header = new ListNode(0);
        header.next = head;

        ListNode preNode = header;

        while (preNode.next != null) {
            if (preNode.next.val == val) {
                preNode.next = preNode.next.next;
            } else {
                preNode = preNode.next;
            }
        }

        return header.next;
    }

    public static void outputList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode tmpPoint = head;
        do {
            System.out.printf("%d->", tmpPoint.val);
            tmpPoint = tmpPoint.next;
        } while (tmpPoint != null);
        System.out.println();
    }

    public static ListNode createList(List<Integer> list) {
        ListNode head = new ListNode(list.get(0));
        ListNode trail = head;

        for (int i = 1; i < list.size(); i++) {
            ListNode tmp = new ListNode(list.get(i));
            trail.setNext(tmp);
            trail = tmp;

        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}