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
public class _337打家劫舍3_1 {

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
        递推方程可以看作
            int method1 = root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right)
            int method2 = rob(root.left) + rob(root.right)
            result = Math.max(method1,method2)

            递归 DFS，选取最大值，自下而上，动态规划，求最优解

            这里 每个节点 在每次计算都要计算一遍，做了好多重复工作
    */
    public int rob(TreeNode root) {
        if (root == null) return 0;

        // 偷某个节点
        int money = root.val;

        // 偷某个左儿子子节点
        if (root.left != null) {
            money += rob(root.left.left) + rob(root.left.right);
        }

        // 偷某个右儿子子节点
        if (root.right != null) {
            money += rob(root.right.left) + rob(root.right.right);
        }

        // 去 情况1\2中最大值
        return Math.max(money, rob(root.left) + rob(root.right));
    }
}
