package com.jun.util;

import java.util.List;

/**
 * @author Jun
 * @date 2020/1/17 下午1:48
 */
public class ArrayUtil {
    private ArrayUtil() {
    }

    public static <T> void outputList_2(List<List<T>> lists) {
        for (List<T> list : lists) {
            outputList_1(list);
        }
    }

//    public static void outputArray_1(int[] list) {
//        if (list != null) {
//            for (int t : list) {
//                System.out.printf("%s ", t);
//            }
//            System.out.println();
//        }
//    }

    public static <T> void outputList_1(List<T> list) {
        for (T t : list) {
            System.out.printf("%s ", t);
        }
        System.out.println();
    }

    public static void outputArray_1(int[] nums, int index) {
        for (int i = 0; i < index; i++) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();
    }

    public static void outputArray_1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();
    }

    public static void outputIntArray_2(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            outputIntArray_1(arr[i]);
        }
    }

    public static void outputIntArray_1(int[] booleans) {
        for (int i = 0; i < booleans.length; i++) {
            System.out.printf(booleans[i] + "\t");
        }
        System.out.println();
    }

    public static void outputBooleanArray_2(boolean[][] arr) {
        for (boolean[] booleans : arr) {
            outputBooleanArray_1(booleans);
        }
    }

    public static void outputBooleanArray_1(boolean[] booleans) {
        for (boolean aBoolean : booleans) {
            System.out.printf(aBoolean + "\t");
        }
        System.out.println();
    }
}
