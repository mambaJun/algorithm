package com.jun._16最接近的三数之和;

import java.util.Arrays;

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
public class _16最接近的三数之和_排序优化1 {
    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 2, 1, -4};
//        int target = 1;

        int[] nums = new int[]{1, 1, 1, 0};
        int target = -100;
        System.out.println(threeSumClosest(nums, target));
    }

    /*
        二分查找思想：
            这个题目仅仅是要最优解，跟数组的顺序无关，可以先排序，选取数组中点，二分查找

    */
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        // 初始参考值
        int result = nums[0] + nums[1] + nums[2];
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;

        return result;
    }
}
