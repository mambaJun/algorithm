package com.jun._94二叉树的中序遍历;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Jun
 * @date 2020/5/6 上午12:08
 */
public class _94二叉树的中序遍历_循环迭代版 {

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
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            list.add(currentNode.val);
            currentNode = currentNode.right;
        }

        return list;
    }


    private void traversal(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        traversal(list, node.left);
        list.add(node.val);
    }


}
