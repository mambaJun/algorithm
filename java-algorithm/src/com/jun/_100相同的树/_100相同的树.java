package com.jun._100相同的树;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @author Jun
 * @date 2020/7/23 下午9:58
 */
public class _100相同的树 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == null && q == null;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
