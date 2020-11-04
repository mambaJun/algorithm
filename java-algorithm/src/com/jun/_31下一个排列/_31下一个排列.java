package com.jun._31下一个排列;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: Jun
 * @date: 2020/11/2 20:21
 */
public class _31下一个排列 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
//        int[] nums = {1, 2, 3};
//        int[] nums = {3, 2, 1};
//        int[] nums = {2, 3, 1};
        Solution solution = new Solution();
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution {
    public void nextPermutation(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) < 2) return;

        int right = n - 1;
        int left = right - 1;

        // 从后查找第一个 升序
        while (left >= 0) {
            if (nums[left] < nums[right]) break;
            left--;
            right--;
        }

        // 注意 转折点不存在
        if (left >= 0) {
            // 从后查找第一个 大于转折点的，节点并替换
            for (int i = n - 1; i >= right; i--) {
                if (nums[left] < nums[i]) {
                    swap(nums, left, i);
                    break;
                }
            }
        }

        // 转折点后，逆置
        revert(nums, right, n - 1);
    }

    public void revert(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
            // start++;
            // end--;
        }
    }

    public void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}