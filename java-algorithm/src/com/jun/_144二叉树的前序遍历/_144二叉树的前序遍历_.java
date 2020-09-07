package com.jun._144二叉树的前序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
public class _144二叉树的前序遍历_ {

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

        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            list.add(currentNode.val);
            while (currentNode != null) {
                stack.push(currentNode.left);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            if (currentNode.right == null) {
                currentNode = stack.pop();
            } else {
                currentNode = currentNode.right;
            }


        }

        return list;
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
