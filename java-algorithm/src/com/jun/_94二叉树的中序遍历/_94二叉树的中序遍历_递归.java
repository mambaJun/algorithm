package com.jun._94二叉树的中序遍历;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jun
 * @date 2020/5/6 上午12:08
 */
public class _94二叉树的中序遍历_递归 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        traversal(root, list);
        return list;
    }

    private void traversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            if (node.left != null) {
                traversal(node.left, list);
            }
            list.add(node.val);
            if (node.right != null) {
                traversal(node.right, list);
            }

        }
    }
}
