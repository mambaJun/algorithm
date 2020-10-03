package com.jun._1_test;

import java.util.*;

/**
 * @author: Jun
 * @date: 2020/9/24 8:25
 */
public class Delete_1 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        Map<Integer, Integer> map = new HashMap(16);
        find(root, map);
        int countMax = 0;

        for (Integer key : map.keySet()) {
            countMax = Math.max(countMax, map.get(key));
        }

        List<Integer> res = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == countMax) {
                res.add(entry.getKey());
            }
        }
//        return res.to
        return null;
    }

    public void find(TreeNode root, Map<Integer, Integer> map) {
        if (root != null) {
            if (!map.containsKey(root.val)) {
                map.put(root.val, 1);
            } else {
                map.put(root.val, map.get(root.val) + 1);
            }
        }

    }
}
