package com.jun._88合并两个有序数组_88;

import java.util.Scanner;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/2/3 下午2:22
 */
public class 合并两个有序数组_88 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] nums1 = getArray(m + n, m);
        int[] nums2 = getArray(n, n);
        merge(nums1, m, nums2, n);
    }

    private static int[] getArray(int length, int number) {
        int[] arr = new int[length];
        for (int i = 0; i < number; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[index--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n >= 0) {
            nums1[index--] = nums2[n--];
        }
    }
}
