package com.jun._144二叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 *
 * @author Jun
 * @date 2020/5/6 下午11:47
 */
public class _144二叉树的前序遍历_递归版 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        traversal(list, root);
        return list;
    }

    private void traversal(List<Integer> list, TreeNode node) {
        if (node != null) {
            list.add(node.val);
            if (node.left != null) {
                traversal(list, node.left);
            }
            if (node.right != null) {
                traversal(list, node.right);
            }
        }
    }

    boolean hasChild(TreeNode node) {
        return hasLeftChild(node) || hasRightChild(node);
    }

    boolean hasLeftChild(TreeNode node) {
        return node.left != null;
    }

    boolean hasRightChild(TreeNode node) {
        return node.right != null;
    }
}
