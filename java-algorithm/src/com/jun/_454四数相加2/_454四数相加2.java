package com.jun._454四数相加2;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定四个包含整数的数组列表A , B , C , D ,计算有多少个元组 (i, j, k, l)，使得A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过231 - 1 。
 * <p>
 * 例如:
 * <p>
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/11/27 下午1:09
 */
public class _454四数相加2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        System.out.println(solution.fourSumCount(A, B, C, D));
    }
}

class Solution {
    /*
            四层 for 计算   (超时)
            回溯法     (超时) 如果找不到剪枝优化的情况下，还不如 for枚举
                    枚举全部情况 + 减枝优化
            哈希表
                    将 O(n^4) 优化成 O(n^2)， 这里 为啥 会是 n^2,关键是 4/2 的运算吧，这样就会得到最小的层数
    */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        int count = 0;

        for (int c : C) {
            for (int d : D) {
                if (map.containsKey(-c - d)) {
                    count += map.get(-c - d);
                }
            }
        }

        return count;
    }
}