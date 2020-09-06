package com.jun._53最大子序和_53;

/**
 * @author Jun
 * @date 2020/2/2 下午12:53
 */
public class 最大子序和_53_dp {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {-2, -1};
//        int[] nums = {-2, -1, -2};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {

        if(nums.length == 0) return 0;

        // 一段段的子数列的和
        int sum = nums[0];
        int now = nums[0];
        System.out.printf("sum=%d  now=%d\n",sum,now);
        for (int i = 1; i < nums.length; i++) {

            // 前面累加的增长 > 0 继续加，
            // 前面累加的增长 < 0 的所有累加的增长都白干，就从这一次开始
            now = now < 0 ? nums[i] : now + nums[i];

            // now 等于 从前面某一天到现在的增长
            if (now > sum) sum = now;

            System.out.printf("sum=%d  now=%d nums[%d]=%d\n",sum,now,i,nums[i]);

        }
        return sum;
    }
}