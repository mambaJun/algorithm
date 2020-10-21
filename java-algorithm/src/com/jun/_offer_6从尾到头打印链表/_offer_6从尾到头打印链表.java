package com.jun._offer_6从尾到头打印链表;

import java.util.Arrays;

/**
 * @author Jun
 * @date 2020/10/21 下午12:42
 */
public class _offer_6从尾到头打印链表 {
    public static void main(String[] args) {
        ListNode listNode = buildList(4);
        printList(listNode);
        System.out.println(Arrays.toString(reversePrint(listNode)));
    }

    public static int[] reversePrint(ListNode head) {
        ListNode curr = head;
        ListNode next = null;
        ListNode result = null;

        int n = 0;
        while (curr != null) { // 当前节点指向  NULL 时，整个链表 逆置 结束
            // 先将 当前 节点的下一个位置记录下来
            next = curr.next;
            // 当前节点 指向 result
            curr.next = result;
            // result 往前移动
            result = curr;
            // 当前节点 指向 下一个节点
            curr = next;

            n++;
        }
        head = result;

        int[] res = new int[n];
        int index = 0;
        while (head != null) {
            res[index++] = head.val;
            head = head.next;
        }

        return res;
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
        ListNode head = new ListNode(0);
        ListNode tail = head;
        int i = 0;
        while (++i <= n) {
            ListNode node = new ListNode(i);
            tail.next = node;
            tail = tail.next;
        }
        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
