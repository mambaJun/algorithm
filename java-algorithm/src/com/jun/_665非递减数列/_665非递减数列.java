package com.jun._665非递减数列;

/**
 * @author Jun
 * @date 2021/2/7 下午4:20
 */
public class _665非递减数列 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 2, 1};
        System.out.println(solution.checkPossibility(nums));
    }
}

class Solution {
    // 方法二
    public boolean checkPossibility1(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 1; i < n && count <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                if (i >= 2 && nums[i - 2] > nums[i]) { // 消除 如果修改 nums[i - 1]的话，nums[i - 2]不符合的情况
                    nums[i] = nums[i - 1];
                }
            }
        }
        return count <= 1;
    }
    // 方法一,找到不是非递增处，分别处理两边的，同时判断是不是已经有序了，若两次中已经有序了，返回true, 否则返回 false(此题是至多修改一次，可用。若给定k次的话，需要对时间上进行评估)
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                int left = nums[i - 1];
                int right = nums[i];
                nums[i - 1] = right;
                if (isSort(nums, i - 1)) return true;
                nums[i - 1] = left;
                nums[i] = left;
                return isSort(nums, i - 1);
            }
        }

        return true;
    }

    boolean isSort(int[] nums, int start) {
        int n = nums.length;
        if (start < 1) start = 1;
        for (int i = start; i < n; i++) {
            if (nums[i - 1] > nums[i]) return false;
        }
        return true;
    }
}