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
        int[] nums = new int[]{0, 2, 1, -3};
        int target = 1;

//        int[] nums = new int[]{-1, 2, 1, -4};
//        int target = 1;

//        int[] nums = new int[]{1, 1, 1, 0};
//        int target = -100;
        System.out.println(threeSumClosest(nums, target));
    }

    /*
        首先先明确一下两个概念：
            顺序问题：一个数组只能按照按照连接顺序进行考虑问题（二分模型）
            组合问题：一个数组可以按照任意顺序组合 进行 考虑问题 (双指针模型)
        这个题目优化思路最关键的问题在 sum = nums[mid - 1] + nums[mid] + nums[mid + 1] 看似没有错，其实已经把问题思路固定了 顺序问题，所以 下面的优化思路 对此题不符合

        二分查找思想：
            这个题目仅仅是要最优解，跟数组的顺序无关，可以先排序，选取数组中点，二分查找
        nums = [-1, 2, 1, -4]
        target = 1
        start = 0   end = 3     mid = (0+3)/2 = 1
            sum = nums[mid - 1] + nums[mid] + nums[mid + 1]
            if (Math.abs(target - sum) <= Math.abs(target - result)) {
                end = mid - 1;
                result = sum;
            }
            if (Math.abs(target - sum) > Math.abs(target - result)) {
                start = mid + 1;
                result = sum;
            }
            // 相等的话 需要分开考虑，求两边最合适的
            if (Math.abs(target - sum) == Math.abs(target - result)) {
                // 递归
            }
    */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        // 初始结果
        int result = nums[0] + nums[1] + nums[2];
        // 起点
        int start = 0;
        // 终点
        int end = nums.length - 1;

        return getThreeSumClosest(start, end, nums, target, result);
//        return getThreeSumClosest(0, nums.length - 1, nums, target, nums[0] + nums[1] + nums[2]);
    }

    public static int getThreeSumClosest(int start, int end, int[] nums, int target, int result) {

        // 递归出口
        if (start >= end) {
            return result;
        }
        // 求中点
        int mid = (start + end) / 2;

        // 根据中点计算三数和
        int sum = nums[mid - 1] + nums[mid] + nums[mid + 1];

        // 和已有的结果比较结果
        // 结果在左区间
        if (Math.abs(target - sum) < Math.abs(target - result)) {
            return getThreeSumClosest(start, mid - 1, nums, target, sum);
        }

        // 结果在右区间
        if (Math.abs(target - sum) > Math.abs(target - result)) {
            return getThreeSumClosest(mid + 1, end, nums, target, sum);
        }

        // 新值 等于 旧值
        int right = getThreeSumClosest(start, mid - 1, nums, target, result);
        int left = getThreeSumClosest(mid + 1, end, nums, target, result);
        return Math.abs(target - right) < Math.abs(target - left) ? right : left;
    }
}
