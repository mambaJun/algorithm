package com.jun._114二叉树展开成链表;

/**
 * @author Jun
 * @date 2020/8/2 上午12:07
 */
public class _114二叉树展开成链表 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        System.out.println();
    }
}
