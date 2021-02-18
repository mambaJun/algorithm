package com.jun.offer53在排序数组中查找数字_1;

/**
 * @author Jun
 * @date 2021/2/18 下午11:18
 */
public class offer53在排序数组中查找数字_1 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
//        int[] nums = {1};
//        int target = 1;
        Solution solution = new Solution();
        System.out.println(solution.search(nums, target));
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                int l = mid;
                int r = mid;

                while (l - 1 >= left && nums[l - 1] == target) {
                    l--;
                }
                while (r + 1 <= right && nums[r + 1] == target) {
                    r++;
                }
                return r - l + 1;
            }
        }

        return 0;
    }
        /*
        0  1  2  3  4  5
        [5,7,7,8,8,10]
L       0  3
R       5  5
m      2  4

        */
}