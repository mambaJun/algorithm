package com.jun._2两数相加;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/7/19 下午11:26
 */
public class _2两数相加_improve_1 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {5};
        ListNode l1 = createList(nums1);
        printList(l1);

        int[] nums2 = {5};
        ListNode l2 = createList(nums2);
        printList(l2);

        ListNode plusResult = addTwoNumbers(l1, l2);
        System.out.println("---------------------");
        printList(plusResult);
    }


    /*
        将 逻辑且 改成 了 逻辑非，从而将 相同代码 改为 只剩一个地方
        用 有头链表，后插法，构建结果链表
    */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode head = new ListNode(0);
        ListNode tail = head;

        int carry = 0;

        while (p != null || q != null) {
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = carry + x + y;

            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            p = p != null ? p.next : null;
            q = q != null ? q.next : null;
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head.next;
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

}
