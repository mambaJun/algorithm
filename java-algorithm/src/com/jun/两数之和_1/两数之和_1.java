package com.jun.两数之和_1;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author Jun
 * @date 2020/1/17 下午2:46
 */

import com.jun.util.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

public class 两数之和_1 {
    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        int target = 9;
        int[] nums = {0, 4, 3, 0};
        int target = 0;
        ArrayUtil.outputArray_1(twoSum(nums, target));
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}


/*
    Map<Integer, Integer> map = new HashMap<>(nums.length);
    for (int i = 0; i < nums.length; i++) {
    if (map.containsKey(target - nums[i])) {
    return new int[]{map.get(target - nums[i]), i};
    }
    map.put(nums[i], i);
    }
    return null;
*/
