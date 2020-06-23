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
public class _303区域和检测_数组不可变 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        int i = 0;
        int j = 2;
        NumArray obj = new NumArray(nums);
        int result = obj.sumRange(i, j);
        System.out.println(result);
    }
}

class NumArray {
    private int[] nums;
    private int[][] result;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.result = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i][i] = nums[i];
        }
    }

    /*
        -2  0   3   -5  2   -1
    -2  -2
    0       0
    3           3
    2                   2
    -1                         -1
    */
    public int sumRange(int i, int j) {

        int length = nums.length;
        if (i > j || length < 1) {
            return 0;
        }

        for (int k = 0; k <; k++) {

        }

        for (int row = 0; row < length; row++) {
            for (int clu = 0; clu < length; clu++) {
                result[row][clu] =
            }
        }
        return 0;
    }
}
