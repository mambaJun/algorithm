package com.jun._128最长连续序列;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: Jun
 * @date: 2020/7/11 18:46
 */
public class _128最长连续序列 {
    // 参考 算法第四版 P136 union find 算法
    // 并集合算法
    /*
        这里我先简单描述一下 union find 的思路
        1、用一个一维数组 的下标进行表示 点之间的关系
        2、用一维数组 表示 树
        3、用一维数组 表示 加权树

        这道题我的思路：
            利用上面的第三种方法 将连续的序列看成一棵树，
            将整个数组存完后，将数节点最多的那棵树 打印
    */
}
