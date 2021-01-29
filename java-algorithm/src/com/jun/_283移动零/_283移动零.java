package com.jun._283移动零;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/11/19 上午7:57
 */
public class _283移动零 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 1, 0, 3, 12};
//        int[] nums = {0, 0, 1};
        System.out.println(Arrays.toString(nums));
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

/*
思路二：
    移位， 从后向前找 0 ， 移位
 */
class Solution {

    /*
    假删除 0 元素后 再 后面 补齐
     */
    public void moveZeroes2(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) < 2) return;

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            nums[index++] = nums[i];
        }

        for (int i = index; i < n; i++) {
            nums[i] = 0;
        }
    }

    /*
    一边删除，一边将 0元素后置
     */
    public void moveZeroes(int[] nums) {
        int n;
        if (nums == null || (n = nums.length) < 2) return;

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
                index++;
            }
        }
    }

    public void moveZeroes1(int[] nums) {
        int n;
        if ((n = nums.length) < 2) return;

        int count = 0;
        for (int i = 0; i + count < n && i < n; i++) {
            if (i > 0 && nums[i - 1] == 0) {
                i--;
            }
            if (nums[i] == 0) {
                for (int j = i + 1; j < n; j++) {
                    nums[j - 1] = nums[j];
                }
                nums[n - 1] = 0;
                count++;
            }
        }
    }
}
