package com.jun._337打家劫舍3;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * <p>
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3,null,3,null,1]
 * <p>
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * <p>
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 * <p>
 * 输入: [3,4,5,1,3,null,1]
 * <p>
 *   3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * <p>
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/8/5 上午11:27
 */
public class _337打家劫舍3_3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
        如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
        建立模型就是如果
            1、父节点 偷了 其子节点就不能偷了，孙子节点可以偷
            2、父子节点没偷，儿子节点可以偷，孙子不能偷了
        当前节点不偷
            当前最大钱数 = 左孩子最大数 + 右孩子最大数
        当前节点偷
            当前最大钱数 = 当前节点钱数 + 左、右孩子都不偷

         e
        每个节点都有两种状态
        int[] res = new int[2]
            偷   1
            不偷  0
        root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]

    */
    public int rob(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];

        // 创建 当前返回结果的
        int[] result = new int[2];

        // 左节点
        int[] left = robInternal(root.left);
        // 右节点
        int[] right = robInternal(root.right);

        //  不偷
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷当前节点
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
}
