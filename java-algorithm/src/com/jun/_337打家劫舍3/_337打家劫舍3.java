package com.jun._337打家劫舍3;

/**
 * @author Jun
 * @date 2020/8/5 上午11:27
 */
public class _337打家劫舍3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode node) {
        // 后序遍历
        if (node == null) {
            return new int[]{0, 0};
        }

        // 当前节点偷或者不偷
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int[] dp = new int[2];
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = node.val + left[0] + right[0];
        return dp;
    }
}
