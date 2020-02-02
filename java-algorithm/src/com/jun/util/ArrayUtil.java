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
}
