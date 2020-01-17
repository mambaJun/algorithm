package com.jun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *red
 * @author Jun
 * @date 2020/1/11 上午12:44
 */
public class 四数之和_18 {


    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        fourSum(nums, target);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int minLength = 4;
        if (nums.length < minLength) return result;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] > target) break;
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int l = i + 1;
                int r = nums.length - 1;
                int mid = l + 1;
                while (l < r) {
                    if (nums[i] + nums[l] + nums[mid] + nums[r] == target) {
                        result.add(Arrays.asList(nums[i], nums[l], nums[mid], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                        while ((l < r && nums[r] == nums[r - 1])) r--;
                        r--;
                    } else if (nums[i] + nums[l] + nums[mid] + nums[r] < target) {
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                    } else {
                        while ((l < r && nums[r] == nums[r - 1])) r--;
                        r--;
                    }
                }
            }
        }
        return result;
    }
}
