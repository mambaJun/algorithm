package com.jun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jun
 * @date 2020/1/11 上午12:44
 */
public class FourNum {


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
