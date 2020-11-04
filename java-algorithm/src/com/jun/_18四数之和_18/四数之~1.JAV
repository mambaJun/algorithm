package com.jun._18四数之和_18;

import com.jun.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * @author Jun
 * @date 2020/1/11 上午12:44
 */
public class 四数之和_18 {
    public static void main(String[] args) {
//        int[] nums = {-5, -4, -3, -2, -1, 0, 0, 1, 2, 3, 4, 5};
//        int target = 0;

//        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
//        int target = -11;

        int[] nums = {0, 4, -5, 2, -2, 4, 2, -1, 4};
        int target = 12;
        ArrayUtil.outputList_2(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        int length = nums.length;

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] != nums[i - 1]) {
                continue;
            }
            // 每层添加 极值判断，用来减少循环
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int h = length - 1;
                if (nums[i] + nums[j] + nums[k] + nums[k + 1] > target) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[h] + nums[h - 1] < target) {
                    continue;
                }

                while (k < h) {
                    if (nums[i] + nums[j] + nums[k] + nums[h] == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[h]));
                        k = moveLeft(nums, k, h);
                        h = moveRight(nums, k, h);
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] + nums[h] > target) {
                        h = moveRight(nums, k, h);
                        continue;
                    }
                    k = moveLeft(nums, k, h);
                }
            }
        }
        return result;
    }

    private static int moveRight(int[] nums, int l, int r) {
        while (l < r && nums[r] == nums[r - 1]) r--;
        r--;
        return r;
    }

    private static int moveLeft(int[] nums, int l, int r) {
        while (l < r && nums[l] == nums[l + 1]) l++;
        l++;
        return l;
    }
}