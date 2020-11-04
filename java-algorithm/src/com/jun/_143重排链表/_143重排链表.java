package com.jun._143重排链表;


/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: Jun
 * @date: 2020/10/20 14:13
 */
public class _143重排链表 {
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

    public static void main(String[] args) {
        ListNode list = build(5);
        print(list);

    }

    public static void reorderList(ListNode head) {
        if (head == null) return;

        ListNode tail = head;
        while (tail.next != null) {
            tail.next = revert(tail.next);
        }
    }

    static ListNode revert(ListNode head) {

        ListNode curr = head;
        ListNode next = null;
        ListNode res = null;

        while (curr != null) {
            next = curr.next;
            curr.next = res;
            res = curr;
            curr = next;
        }

        return res;
    }

    static void print(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.printf(tmp.next == null ? "%d" : "%d->", tmp.val);
            tmp = tmp.next;
        }
        System.out.println();
    }

    static ListNode build(int n) {
        ListNode head = new ListNode(0, null);
        ListNode tail = head;

        for (int i = 1; i <= n; i++) {
            tail.next = new ListNode(i, null);
            tail = tail.next;
        }
        return head.next;
    }
}
