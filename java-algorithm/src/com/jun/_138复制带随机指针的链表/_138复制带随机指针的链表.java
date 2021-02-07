package com.jun._138复制带随机指针的链表;

/**
 * @author Jun
 * @date 2021/2/7 下午6:36
 */
public class _138复制带随机指针的链表 {
    // Definition for a Node.
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        Node list = createList(2);
        printList(list);
        Solution solution = new Solution();
        Node node = solution.copyRandomList(list);
        printList(node);
    }

    private static Node createList(int n) {
        Node head = new Node(0);
        Node curr = head;
        while (n-- > 0) {
            Node node = new Node(n);
            curr.next = node;
            curr = node;
        }
        return head.next;
    }

    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.printf((curr.next != null ? "%d->" : "%d "), curr.val);
            curr = curr.next;
        }
        System.out.println();
    }

    private static class Solution {

        /*
        方式3:将每个节点先复制当前节点后面，生成的新链表，奇数位置是old，偶数位置是new,然后 进行奇偶拆分
        */
        public Node copyRandomList(Node head) {
            if (head == null) {
                return head;
            }
            // 每个节点先复制当前节点后面，生成的新链表
            Node curr = head;
            while (curr != null) {
                Node node = new Node(curr.val);
                node.next = curr.next;
                curr.next = node;
                curr = node.next;
            }
            // while ()
            //奇数位置是old，偶数位置是new 连接 random
            curr = head;
            while (curr != null) {
                if (curr.random != null) {
                    curr.next.random = curr.random.next;
                }
                curr = curr.next.next;
            }
            // 进行奇偶拆分
            /*
                4->4->3->3->2->2->1->1->0->0
                                        H  T
                                  H  T
                            H  T
                      H  T
                H  T
            */
            Node result = head.next;
            Node tail = result;
            curr = head;
            while (curr != null) {
                curr.next = curr.next.next;
                curr = curr.next;
                // 当 curr 到达倒第二个时，tail到最后一个,tail 无需执行
                if (tail.next != null) {
                    tail.next = tail.next.next;
                    tail = tail.next;
                }
            }

            return result;
        }
    }
}

