package com.jun._105从前序与中序遍历序列构造二叉树;

import org.omg.CORBA.INTERNAL;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /    \
 * 15     7
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/12/2 下午4:04
 */
public class _105从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Solution.TreeNode root = solution.buildTree(preorder, inorder);
        System.out.println("---------------");
    }
}

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> map = null;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen != inLen) {
            throw new RuntimeException("Incorrect input data.");
        }

        map = new HashMap<>();
        // 优化每次可以直接 找 节点
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }

//        return buildTree(preorder, 0, preLen - 1, map, 0, inLen - 1);
        return myBuildTree(preorder, inorder, 0, preLen - 1, 0, inLen - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {


        if (preLeft > preRight) return null;

        // 前 中 序 根节点，对应的 id
        int preRoot = preLeft;
        int inRoot = map.get(preorder[preRoot]);

        TreeNode root = new TreeNode(preorder[preRoot]);
        int leftSubtreeSize = inRoot - inLeft;

        root.left = myBuildTree(preorder, inorder, preLeft + 1, preLeft + leftSubtreeSize, inLeft, inRoot - 1);
        root.right = myBuildTree(preorder, inorder, preLeft + 1 + leftSubtreeSize, preRight, inRoot + 1, inRight);
        return root;
    }

/*    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {


        if (preorder_left > preorder_right) return null;

        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = map.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }*/

    /*
        x - (preLeft + 1) = pIndex - 1 - inLeft
    */
    private TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        // 前序 遍历 中的 第一个节点 （根节点）
        int preRoot = preLeft;
        // 中序遍历定位的 根节点
        int inRoot = map.get(preorder[preRoot]);
        // 先把根节点 建立 出来
        TreeNode root = new TreeNode(preorder[preRoot]);
        int leftSubtreeLen = inRoot - inLeft;
        // 递归 构造 左子树
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = buildTree(preorder, inorder, preLeft + 1, preLeft + leftSubtreeLen, inLeft, inRoot - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = buildTree(preorder, inorder, preLeft + leftSubtreeLen + 1, preRight, inRoot + 1, inRight);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                               Map<Integer, Integer> map,
                               int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }

        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int pIndex = map.get(rootVal);
        root.left = buildTree(preorder, preLeft + 1,
                pIndex - inLeft + preLeft, map, inLeft, pIndex - 1);
        root.right = buildTree(preorder,
                pIndex - inLeft + 1, preRight, map, pIndex + 1, inRight);
        return root;
    }

}
