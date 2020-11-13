package com.jun.util;

/**
 * @author Jun
 * @date 2020/11/13 下午3:41
 */
public class ListUtil {
    private ListUtil() {
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

    public static ListNode createList(int start, int end, int step) {
        ListNode head = null;
        for (int i = start; i <= end; i += step) {
            ListNode newNode = new ListNode(i);
            newNode.next = head;
            head = newNode;
        }
        return head;
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
