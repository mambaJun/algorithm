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

public class _303区域和检测_数组不可变_2_dp {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        int i = 0;
        int j = 2;
        NumArray_1 obj = new NumArray_1(nums);
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }
}

/**
 * 超出内存限制
 * 想法一个二维数组 坐标 i,j 看作从 i 到 j 的和
 */
class NumArray_1 {
    private int[] nums;
    private Integer[][] result;

    public NumArray_1(int[] nums) {
        this.nums = nums;

        int length = nums.length;
        this.result = new Integer[length][length];
        for (int i = 0; i < length; i++) {
            result[i][i] = nums[i];
        }
    }

    public int sumRange(int i, int j) {

        int length = nums.length;
        if (i > j || length < 1) {
            return 0;
        }

        if (result[i][j] != null) {
            return result[i][j];
        }
        /*
            i 看作一维
            j 看作二维
        */

        int clu = i;
        for (int row = 0; row <= j; row++) {
            if (row == 0) {
                result[clu][row] = nums[row];
                continue;
            }
            if (result[clu][row] == null) {
                result[clu][row] = result[clu][row - 1] + nums[row];
            }
        }

        return result[i][j];
    }
}
