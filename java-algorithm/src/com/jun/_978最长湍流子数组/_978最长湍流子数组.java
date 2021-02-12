package com.jun._978最长湍流子数组;

/**
 * 当 A的子数组A[i], A[i+1], ..., A[j]满足下列条件时，我们称其为湍流子数组：
 * <p>
 * 若i <= k < j，当 k为奇数时，A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若i <= k < j，当 k 为偶数时，A[k] > A[k+1]，且当 k为奇数时，A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * <p>
 * 返回 A 的最大湍流子数组的长度。
 * <p>
 * 
 * <p>
 * 示例 1：
 * <p>
 * 输入：[9,4,2,10,7,8,8,1,9]
 * 输出：5
 * 解释：(A[1] > A[2] < A[3] > A[4] < A[5])
 * 示例 2：
 * <p>
 * 输入：[4,8,12,16]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[100]
 * 输出：1
 * 
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 40000
 * 0 <= A[i] <= 10^9
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2021/2/8 下午4:34
 */
public class _978最长湍流子数组 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {};
        System.out.println(solution.maxTurbulenceSize(arr));
    }
}

class Solution {
    /*
        首先先弄清楚 什么是湍流子数组：
            当 A的子数组A[i], A[i+1], ..., A[j]满足下列条件时，我们称其为湍流子数组：
            若i <= k < j，当 k为奇数时，A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
            或 若i <= k < j，当 k 为偶数时，A[k] > A[k+1]，且当 k为奇数时，A[k] < A[k+1]。
            也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。

    */
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n == 1) return n;

        int left = 0;
        int right = 0;

        int res = 0;

        while (right < n - 1) {
            if (left == right) {
                if (arr[right] == arr[right + 1]) left++;
                right++;
            } else {
                if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) right++;
                else if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) right++;
                else left = right;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}