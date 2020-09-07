package com.jun._19删除链表的倒数第N个节点;


import com.jun._2两数相加._2两数相加_improve_1;

/**
 * @author Jun
 * @date 2020/7/29 上午8:56
 */
public class _19删除链表的倒数第N个节点 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        ListNode list = createList(nums);
//        printList(list);
        ListNode removedList = removeNthFromEnd(list, 2);
        printList(removedList);

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = getListLength(head) - n;
        ListNode tmpHead = dummy;
        while (length > 0) {
            tmpHead = tmpHead.next;
            length--;
        }
        // 跳过下一个节点
        tmpHead.next = tmpHead.next.next;

        return dummy.next;
    }

    public static int getListLength(ListNode head) {
        int sum = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            sum++;
        }
        return sum;
    }

    public static ListNode createList(int[] nums) {
        ListNode head = null;
        for (int i = 0; i < nums.length; i++) {
            ListNode newNode = new ListNode(nums[i]);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public static void printList(ListNode head) {
        ListNode tmpHead = head;
        while (tmpHead != null) {
            System.out.printf("%d", tmpHead.val);
            if (tmpHead.next != null) {
                System.out.printf("->");
            }
            tmpHead = tmpHead.next;
        }
        System.out.println();
    }

}
