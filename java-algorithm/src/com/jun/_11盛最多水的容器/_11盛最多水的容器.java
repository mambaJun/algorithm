package com.jun._11盛最多水的容器;

import edu.princeton.cs.algs4.StdOut;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/7/27 上午8:01
 */
public class _11盛最多水的容器 {

    public static void main(String[] args) {
//        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] nums = {2, 3, 4, 5, 18, 17, 6};
        System.out.println(maxArea(nums));
    }

    /*
    双指针 问题模型
    双指针问题类似二分查找，只不过 左右指针变化的步长 区别
    具体问题：
    双指针 每次只求当前最优解，按照短板效应 每次只需要找出最短板即可
    */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            int area = height[left] < height[right] ? (right - left) * height[left] : (right - left) * height[right];
            res = res < area ? area : res;

            // 更新 指针
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
