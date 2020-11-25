package com.jun._1_test;


import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;

public class Delete {
    public static void main(String[] args) {
        int[][][][] arr = {{{{1}, {2}, {3}, {3}}}};

        System.out.println(Arrays.deepToString(arr));
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.hashCode());
        System.out.println(now.toEpochSecond(ZoneOffset.MAX));
        System.out.println(now.getHour());
        System.out.println(now.getNano());
        System.out.println(Integer.hashCode(new Integer(10000)));
    }
}
