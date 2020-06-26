package com.jun._16最接近的三数之和;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/6/24 下午11:02
 */
public class _16最接近的三数之和 {
    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 2, 1, -4};
//        int target = 1;

        int[] nums = new int[]{1, 1, 1, 0};
        int target = -100;
        System.out.println(threeSumClosest(nums, target));
    }

    /*
        nums = new int[]{-1, 2, 1, -4};
        target = 1
        | target - （nums[i] + nums[j] + nums[k]）| 求绝对值选择更 接近0，这个还是一维坐标轴的问题
        -1 + 2 + 1 = 2      1 - 2 = -1      1
        -1 + 2 + -4 = -3    1 - -3 = 4      4
        2 + 1 + -4 = -1     1 - -1 = 2      2

        nums = new int[]{1, 1, 1, 0};
        target = -100
        1 + 1 + 1 = 3       -100 - 3 = -103 103
        1 + 1 + 0 = 2       -100 - 2 = -102 102
        1 + 1 + 0 = 2       -100 - 2 = -102 102
    */
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    result = Math.abs(target - sum) < Math.abs(target - result) ? sum : result;
                }
            }
        }

        return result;
    }
}
