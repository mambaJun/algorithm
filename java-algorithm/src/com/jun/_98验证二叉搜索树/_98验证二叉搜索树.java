package com.jun._98验证二叉搜索树;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jun
 * @date 2020/8/6 下午10:33
 */
public class _98验证二叉搜索树 {

    Map<TreeNode, Boolean> memory = new HashMap<>();

    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;


        int val = root.val;
        if (lower != null && val > lower) return false;
        if (upper != null && val > upper) return false;

        if (!dfs(root.left, lower, val)) return false;
        if (!dfs(root.right, val, upper)) return false;

//        return dfs(root.left, lower, val) && dfs(root.right, val, upper);
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
