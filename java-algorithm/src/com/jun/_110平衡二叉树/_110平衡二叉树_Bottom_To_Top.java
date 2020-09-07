package com.jun._110平衡二叉树;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回 false 。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/7/24 下午8:23
 */
public class _110平衡二叉树_Bottom_To_Top {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /*
        这个 自下向上  可以看作是 二叉树 的 先序遍历
     */

    public static boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private static int recur(TreeNode x) {
        if (x == null) return 0;

        int left = recur(x.left);
        if (left == -1) return -1;

        int right = recur(x.right);
        if (right == -1) return -1;

        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }
}
