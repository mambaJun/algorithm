package com.jun.util;

import com.jun._337打家劫舍3._337打家劫舍3_1;

/**
 * @author Jun
 * @date 2020/8/5 下午9:25
 */
public class TreeUtil {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static createTree(int[] nodes) {
        if (nodes == null || nodes.length == 0) return null;

        TreeNode root = new TreeNode(nodes[0]);

    }
}
