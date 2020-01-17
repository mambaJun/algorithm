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
            for (T t : list) {
                System.out.printf("%s ", t);
            }
            System.out.println();
        }
    }
}
