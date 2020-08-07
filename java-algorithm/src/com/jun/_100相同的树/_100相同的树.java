package com.jun._100相同的树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jun
 * @date 2020/7/23 下午9:58
 */
public class _100相同的树 {

    public static void main(String[] args) {
        System.out.println(false ^ false);
        System.out.println(false ^ true);
        System.out.println(true ^ false);
        System.out.println(true ^ true);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == null && q == null;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) return false;

            TreeNode left1 = node1.left;
            TreeNode left2 = node2.left;
            TreeNode right1 = node1.right;
            TreeNode right2 = node2.right;

            if (right1 == null ^ right2 == null) return false;
            if (left1 == null ^ left2 == null) return false;

            if (left1 != null) {
                queue1.offer(left1);
            }
            if (right1 != null) {
                queue1.offer(right1);
            }
            if (left2 != null) {
                queue2.offer(left2);
            }
            if (right2 != null) {
                queue2.offer(right2);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

    /*public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == null && q == null;
        }
        Deque<TreeNode> deque1 = new ArrayDeque<>();
        deque1.addLast(p);

        Deque<TreeNode> deque2 = new ArrayDeque<>();
        deque2.addLast(q);
        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            int size1 = deque1.size();
            int size2 = deque2.size();
            if (size1 != size2) return false;

            while (size1 > 0 && size2 > 0) {
                TreeNode node1 = deque1.poll();
                TreeNode node2 = deque2.poll();

                if (node1 == null || node2 == null) return node1 == null && node2 == null;

                if (node1.val != node2.val) return false;

                deque1.addLast(node1.left);
                deque1.addLast(node1.right);

                deque2.addLast(node2.left);
                deque2.addLast(node2.right);

            }
        }
        return deque1.isEmpty() && deque2.isEmpty();
    }*/
/*
    深搜
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == null && q == null;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }*/
}
