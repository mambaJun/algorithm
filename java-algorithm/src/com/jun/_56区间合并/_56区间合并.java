package com.jun._56区间合并;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: Jun
 * @date: 2020/9/8 12:43
 */
public class _56区间合并 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 4},
                {4, 5}
        };
        int[][] merge = merge(arr);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[1][2];

        Arrays.sort(intervals, Comparator.comparingInt(obj -> obj[0]));
        List<int[]> res = new ArrayList<>();


        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
                continue;
            }
            end = Math.max(end, intervals[i][1]);
        }
        res.add(new int[]{start, end});

        return res.toArray(new int[res.size()][]);
    }
}
