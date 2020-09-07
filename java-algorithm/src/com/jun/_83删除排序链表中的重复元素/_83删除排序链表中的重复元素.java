package com.jun._83删除排序链表中的重复元素;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: Jun
 * @date: 2020/7/22 15:55
 */
public class _83删除排序链表中的重复元素 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 3, 3};
        ListNode list = createList(nums1);
        printList(list);
        ListNode resultList = deleteDuplicates(list);
        printList(resultList);
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

    public static ListNode createList(int[] nums) {
        ListNode head = null;
        for (int i = 0; i < nums.length; i++) {
            ListNode newNode = new ListNode(nums[i]);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode tail = head;

        while (tail != null && tail.next != null) {
            if (tail.val == tail.next.val) {
                tail.next = tail.next.next;
                continue;
            } else {
                tail = tail.next;
            }
        }
        return head;
    }
}
