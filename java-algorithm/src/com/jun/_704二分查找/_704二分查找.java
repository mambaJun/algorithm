package com.jun._704二分查找;

/**
 * @author: Jun
 * @date: 2020/7/11 18:41
 */
public class _704二分查找 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(binarySearch(nums, 9));
    }

    private static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            if (target < nums[mid]) {
                high = mid - 1;
            }

            if (target > nums[mid]) {
                low = mid + 1;
            }
        }

        return -1;

        /*
        算法 第四版
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < nums[mid]) hi = mid - 1;
            else if (key > nums[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
        */
    }


    /**
     * java 自带的二分查找
     *
     * @param a
     * @param fromIndex
     * @param toIndex
     * @param key
     * @return
     */
    private static int binarySearch0(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
}
