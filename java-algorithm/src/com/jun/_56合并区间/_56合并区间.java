package com.jun._56合并区间;

import java.util.Arrays;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/7/17 下午5:28
 */
public class _56合并区间 {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.toString(merge(intervals)));

    }
    /*
         |-----|
     --- |     |
        -|--   |
           --- |
       --------|-----
              -|--
               |   ---
     */

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int[][] result = new int[intervals.length][2];
        int index = -1;
        for (int[] interval : intervals) {
            if (index == -1 || interval[0] > result[index][1]) {
                result[++index] = interval;
            } else {
                result[index][1] = Math.max(result[index][1], interval[1]);
            }
        }

        return Arrays.copyOf(result, index + 1);
/*        for (int i = 0; i < n - 1; i++) {
            // intervals[i + 1]作为参考对象

            // 前 不相交
            if (intervals[i][1] < intervals[i + 1][0]) {

            }

            // 前 相交
            if (intervals[i][0] < intervals[i + 1][0] && intervals[i][1] < intervals[i + 1][1]) {

            }
            // 子集
            if (intervals[i][0] > intervals[i + 1][0] && intervals[i][1] < intervals[i + 1][1]) {

            }
            // 后相交
            if (intervals[i][0] > intervals[i + 1][0] && intervals[i][1] > intervals[i + 1][1]) {

            }

            // 后不相交
            if (intervals[i][0] > intervals[i + 1][1]) {

            }
        }*/

    }
}
