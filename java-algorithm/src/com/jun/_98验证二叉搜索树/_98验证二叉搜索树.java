package com.jun._98验证二叉搜索树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jun
 * @date 2020/8/6 下午10:33
 */
public class _98验证二叉搜索树 {

    public static void main(String[] args) {
    }

    // hash 表存储 节点
    private Map<TreeNode, Boolean> memory = new HashMap<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // true root.left < root.val 左子树
        // false root.right < root.val 右字数
        return dfs(root.left, root.val, true) && dfs(root.right, root.val, false);
    }

    /**
     * 深搜
     *
     * @param node 节点参考 对比值
     * @param val  对比值
     * @param flag 标记是 左子树 还是 右子树
     * @return
     */
    private boolean dfs(TreeNode node, int val, boolean flag) {
        // 末尾 为 true
        if (node == null) return true;
        // 左子树
        if (flag == true && node.val >= val) return false;
        // 右子树
        if (flag == false && node.val <= val) return false;
        // 分支 继续搜索
        if (dfs(node.left, val, flag) == false) return false;
        if (dfs(node.right, val, flag) == false) return false;
        // 当前节点搜索，先从 hash表 查找
        if (memory.containsKey(node)) return memory.get(node);

        // 没有，查找 存入 hash 并返回结果
        boolean result = dfs(node.left, node.val, true) && dfs(node.right, node.val, false);
        memory.put(node, result);

        return result;
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
