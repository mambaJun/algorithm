package com.jun._303区域和检测_数组不可变;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * 示例：
 * <p>
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 * <p>
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 *
 * @author Jun
 * @date 2020/6/23 下午8:19
 */
public class _303区域和检测_数组不可变_一维dp {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        int i = 0;
        int j = 2;
        NumArray_2 obj = new NumArray_2(nums);
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }
}

class NumArray_2 {
    private int[] nums;
    private int[] result;

    public NumArray_2(int[] nums) {
        this.nums = nums;
        this.result = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            result[i + 1] += result[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (nums.length < 1 || i > j) {
            return 0;
        }

        /*
            O(N) 时间进行填充 缓存集
            因为结果包含第i、j两个结果，所以用第j 减去 i -1 就可以得到结果（一位数组画个坐标轴，更直观*） result[j + 1] - result[i]
        */

        return result[j + 1] - result[i];
    }
}
