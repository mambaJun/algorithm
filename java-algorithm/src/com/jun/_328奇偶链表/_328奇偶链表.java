package com.jun._328奇偶链表;

import com.jun.util.ListUtil;

import java.util.List;

/**
 * @author Jun
 * @date 2020/11/13 下午3:39
 */
public class _328奇偶链表 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.ListNode head = solution.createList(5, 1, 1);
        solution.print(head);
        solution.oddEvenList(head);
        solution.print(head);
    }
}

class Solution {
    /*
        新定义了两个节点，用来记录偶数节点，在记录偶数节点的同时 从 主链中删除，遍历结束后将 偶数链 拼接在 主链后
        1 2 3
        1   3
            2
    */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode otherHead = new ListNode(0, null);
        ListNode otherTail = otherHead;

        // tail 一直处在 fsasdfs爽肤水的方式史蒂芬孙
        ListNode tail = head;

//        while (tail != null && )
        return head;
    }

    public void print(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.printf("%d", tmp.val);
            tmp = tmp.next;
            if (tmp != null) System.out.printf("->");
        }
        System.out.println();
    }

    public ListNode createList(int start, int end, int step) {
        ListNode head = null;
        for (int i = start; i >= end; i -= step) {
            ListNode newNode = new ListNode(i);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    protected class ListNode {
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