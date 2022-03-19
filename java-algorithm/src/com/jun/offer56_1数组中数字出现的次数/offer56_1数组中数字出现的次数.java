package com.jun.offer56_1数组中数字出现的次数;

import java.util.Arrays;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 * <p>
 * 限制：
 * <p>
 * 2 <= nums.length <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2021/2/19 下午6:10
 */
public class offer56_1数组中数字出现的次数 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 1, 4, 6};
        System.out.println(Arrays.toString(solution.singleNumbers(nums)));
    }
}

class Solution {
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }

        int div = 1;

        while ((div & res) == 0) {
            div <<= 1;
        }

        int a = 0;
        int b = 0;

        for (int num : nums) {
            if ((div & num) != 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}