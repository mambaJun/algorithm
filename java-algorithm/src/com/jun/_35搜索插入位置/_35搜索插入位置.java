package com.jun._35搜索插入位置;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/7/17 下午4:58
 */
public class _35搜索插入位置 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5};
        int target = 2;

        System.out.println(searchInsert(nums, target));
    }

    /*
        二分查找思想
    */
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > target) {
                end = mid - 1;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            }
            if (nums[mid] == target) {
                return mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        return nums[start] < target ? start + 1 : start;
    }

}
