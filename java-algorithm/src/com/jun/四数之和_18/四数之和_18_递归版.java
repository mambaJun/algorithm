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
//        ArrayUtil.outputList_2(fourSum(nums, target));
    }

/*   public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        kNum(nums, 0, 4, target);

    }*/

 /*    private static List<List<Integer>> kNum(int[] nums, int start, int n, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (n > 2) {
            kNum(nums, start + 1, n - 1, target - nums[start + 1]);
        }

        if (n < 2) {
            return result;
        }

        if (n == 2) {

        }
        return result;
    }*/

}


/*    public static List<List<Integer>> nFourNum(int[] nums, int target, int n, int start) {
        List<List<Integer>> result = new ArrayList<>();
        // 当前位置越界时 返回
        if (start >= nums.length) {
            return result;
        }
        // n的规模大于0时递归减小n的规模
        if (n > 0) {
            for (int i = start; i < nums.length - n - 1; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    List<List<Integer>> tmp = nFourNum(nums, target - nums[i], n - 1, i + 1);
                    if (tmp != null) {
                        for (List<Integer> list : tmp) {
                            list.add(nums[i]);
                        }
                        result.addAll(tmp);
                    }
                }
            }
            return result;
        }
        // n规模减小到0时进行求解，即只需判断target是否为0
        if (target == 0) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(nums[start]);
            result.add(list);
        }
        return result;
    }*/
