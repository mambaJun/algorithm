package com.jun._1207独一无二出现的次数;

/**
 * @author Jun
 * @date 2020/10/28 下午2:31
 */
public class _1207独一无二出现的次数 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        int n = 1000 - -1000 + 10;
        // int n = 10;
        int[] times = new int[n];
        for (int num : arr) {
            times[num + 1000]++;
        }

        // System.out.println(Arrays.toString(times));

        int[] count = new int[1000 + 5];
        for (int time : times) {
            if (time > 0 && ++count[time] > 1) {
                return false;
            }
        }
        return true;
    }
}
