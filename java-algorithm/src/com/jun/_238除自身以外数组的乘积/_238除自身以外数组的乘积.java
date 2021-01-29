package com.jun._238除自身以外数组的乘积;

import java.util.Arrays;

/**
 * 给你一个长度为n的整数数组nums，其中n > 1，返回输出数组output，其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。
 * <p>
 *
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * <p>
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * <p>
 * 说明: 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/11/26 下午7:39
 */
public class _238除自身以外数组的乘积 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(solution.productExceptSelf(nums)));
    }

}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n;
        if (nums == null|| (n = nums.length) == 0) return nums;

        // 第一趟 下 计算 nums 数组中每个元素的 前缀数组
        int[] output = new int[n];
        // 第一个元素的没有前缀，所以 初始化 为 1
        output[0] = 1;
        // 计算 从 [1, n-1]每个元素的 前缀，并且保存在自己的位置上
        for (int i = 1; i < n; i++) output[i] = output[i - 1] * nums[i - 1];

        // 计算每个元素的后缀乘积
        // 因为最后一个元素后面没有元素了， 所以 最后一个的后缀 为 1
        int subfixProduct = 1;
        for (int i = n - 2; i >= 0; i--) {
            // 计算 当前位置的 后缀乘积
            subfixProduct *= nums[i + 1];
            // 将 后缀积 成 当前 元素的 前缀积 (已经存储在当前位置了)
            output[i] *= subfixProduct;
        }
        return output;
    }
}
