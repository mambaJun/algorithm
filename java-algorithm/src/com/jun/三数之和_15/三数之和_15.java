package com.jun.三数之和_15;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * @author jun
 */
public class 三数之和_15 {

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {1, -1, -1, 0};
//        int[] nums = {0, 0, 0, 0};
        int[] nums = {0, 0, 0};
//        int[] nums = {-2, 0, 1, 1, 2};
//        int[] nums = {};
//        int[] nums = {-1, 0, 1, 0};
//        int[] nums = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
        System.out.println(Arrays.deepToString(threeSum(nums).toArray()));

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        int target = 0;
        Arrays.sort(nums);
        if (nums.length < 3) {
            return result;
        }
        if (nums[0] == nums[nums.length - 1] && nums[0] != 0) {
            return result;
        }
        if (nums[0] == nums[nums.length - 1] && nums[0] != 0) {
            result.add(Arrays.asList(0, 0, 0));
            return result;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            // 跳过重复答案
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[i] + nums[l] + nums[r] == target) {
                        result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                        continue;
                    }
                    if (nums[i] + nums[l] + nums[r] < target) {
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                        continue;
                    }
                    if (nums[i] + nums[l] + nums[r] > target) {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                        continue;
                    }
                }
            }
        }
        return result;
    }
}
