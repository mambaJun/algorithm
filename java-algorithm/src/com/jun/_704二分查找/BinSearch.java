package com.jun._704二分查找;

/**
 * @author: Jun
 * @date: 2020/7/16 17:55
 */
public class BinSearch {
    public static int binarySearch(int[] A, int n, int val) {

        int start = 0;
        int end = A.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == val) {
                return mid;
            } else if (A[mid] > val) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (val == A[mid]) {
                return mid;
            }

            if (val < A[mid]) {
                high = mid - 1;
            }

            if (val > A[mid]) {
                low = mid + 1;
            }
        }

        return -1;
    }
}
