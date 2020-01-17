package com.jun.四数之和_18;

import com.jun.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jun
 * @date 2020/1/17 下午3:36
 */
public class 四数之和_18_递归版 {
    public static void main(String[] args) {
//        int[] nums = {-5, -4, -3, -2, -1, 0, 0, 1, 2, 3, 4, 5};
//        int target = 0;

        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
        int target = -11;
        ArrayUtil.outputList_2(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return new ArrayList<>();
        Arrays.sort(nums);
        sum();
        return result;
    }

    public static void sum(){

    }
}