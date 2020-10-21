package com.jun._143重排链表;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jun
 * @date 2020/10/21 上午9:53
 */
public class _143重排链表 {

    public static void main(String[] args) {
        ListNode head = buildList(5);
        printList(head);
        reorderList(head);
        printList(head);
    }

    public static void reorderList(ListNode head) {
        // 入队
        Deque<ListNode> queue = new LinkedList<>();
        while (head != null) {
            ListNode tmpNode = head;
            head = head.next;
            tmpNode.next = null;
            queue.addLast(tmpNode);
        }

        // true-head    F-tail
        ListNode newList = new ListNode(0, null);
        ListNode newTail = newList;
        boolean flag = true;
        while (!queue.isEmpty()) {
            if (flag) {
                newTail.next = queue.removeFirst();
            } else {
                newTail.next = queue.removeLast();
            }
            flag = !flag;
            newTail = newTail.next;
        }

        head = newList.next;
    }

    private static void printList(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.printf(tmp.next == null ? "%d" : "%d->", tmp.val);
            tmp = tmp.next;
        }
        System.out.println();
    }

    private static ListNode buildList(int n) {
        ListNode head = new ListNode(0, null);
        ListNode tail = head;
        int i = 0;
        while (++i <= n) {
            ListNode node = new ListNode(i, null);
            tail.next = node;
            tail = tail.next;
        }
        return head.next;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
