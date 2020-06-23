package com.jun._18四数之和_18;

import com.jun.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jun
 * @date 2020/1/17 下午2:42
 */
public class 四数之和_18_优化1_未完成 {
    public static void main(String[] args) {
        //        int[] nums = {-5, -4, -3, -2, -1, 0, 0, 1, 2, 3, 4, 5};
//        int target = 0;

        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
        int target = -11;
        ArrayUtil.outputList_2(fourSum(nums, target));
    }

    /**
     * 想在 l r 层 采用 两数之和 map 思想
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 1; j < length - 2; ++j) {
                int l = j + 1;
                int r = length - 1;
                while (l < r) {
                    if (nums[i] + nums[j] + nums[l] + nums[r] == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[l] + nums[r] < target) {
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                        continue;
                    }
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                }
                while (j < length - 2 && nums[j] == nums[j + 1]) j++;
            }
            while (i < length - 3 && nums[i] == nums[i + 1]) i++;
        }
        return result;
    }
}
