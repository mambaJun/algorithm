package com.jun._101二叉树的最大深度;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/7/23 下午10:29
 */
public class _101二叉树的最大深度 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
    }

    /*
        一个是递归
        一个是 利用 队列 循环遍历
    */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            // 获取当前层的 节点个数
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            ans++;
        }
        return ans;

/*        if (root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;*/
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) min_depth = minDepth(root.left);
        if (root.right != null) min_depth = minDepth(root.right);

        return min_depth + 1;
    }

}
