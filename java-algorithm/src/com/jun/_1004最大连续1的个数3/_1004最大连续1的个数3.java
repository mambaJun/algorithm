package com.jun._1004最大连续1的个数3;

/**
 * 给定一个由若干 0 和 1 组成的数组A，我们最多可以将K个值从 0 变成 1 。
 * <p>
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 * <p>
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为0或1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2021/2/19 下午4:47
 */
public class _1004最大连续1的个数3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int K = 2;
        System.out.println(solution.longestOnes(nums, K));
    }
}

class Solution {
    public int longestOnes(int[] A, int K) {
                /*
                0 1 2 3 4 5 6 7 8 9 10
                1 1 1 0 0 0 1 1 1 1 0
                          |         |   10-5+1=6
                        | |             5-4+1=2
                |       |               4-0+1=5
                */

        int n = A.length;

        int max = 0;

        int left = -1;
        int right = -1;

        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                while (K == 0) {
                    if (A[++left] == 0) K++;
                }
                K--;
            }
            right++;
            max = Math.max(max, right - left);
//            System.out.printf("i=%d left=%d right=%d K=%d tmp=%d max=%d\n", i, left, right, K, right - left + 1, max);
        }

        return max;
    }
}
