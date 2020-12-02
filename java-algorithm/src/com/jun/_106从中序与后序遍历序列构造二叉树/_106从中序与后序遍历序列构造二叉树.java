package com.jun._106从中序与后序遍历序列构造二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder =[9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/12/2 下午8:12
 */
public class _106从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        Solution.TreeNode root = solution.buildTree(inorder, postorder);
        System.out.println("----- OK ------");
    }
}

class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int[] postorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;
        this.postorder = postorder;
        if (inLen != postLen) {
            return null;
        }

        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(0, postLen - 1, 0, inLen - 1);
    }

    public TreeNode buildTree(int postLeft, int postRight, int inLeft, int inRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        // 精确 定位 每次的 区间 位置，题目可解
        int rootValue = postorder[postRight];
        int inRoot = map.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        int rightSubtreeLen = postRight - inRoot;
        root.left = buildTree(postLeft, inRoot - 1, inLeft, inRoot - 1);
        root.right = buildTree(inRoot, postRight - 1, inRoot + 1, inRight);

        return root;
    }
}