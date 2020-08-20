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
public class _110平衡二叉树_Top_To_Bottom {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }


    private static int height(TreeNode x) {
        if (x == null) return 0;
        return Math.max(height(x.left), height(x.right)) + 1;
    }

    /*
        求每个节点左右节点的高度，一旦发现 将 标记 改为 false ，按理说可以直接结束返回结果了，无奈想不出好办法，才用了个标记的方法
        给每个节点添加一个高度属性更好一点

    public class TreeNode {
        int val;
        int height;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static boolean flag = true;

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        getHeight(root);
        return flag;
    }


    private static int getHeight(TreeNode root) {
        if (!flag) return 0;
        if (root == null) return 0;

        int leftH = getHeight(root.left);
        int rigthH = getHeight(root.right);

        if (Math.abs(leftH - rigthH) > 1) {
            flag = false;
        }

        return Math.max(leftH, rigthH) + 1;
    }
    */

}
