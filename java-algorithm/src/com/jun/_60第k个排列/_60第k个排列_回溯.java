package com.jun._60第k个排列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jun
 * @date 2020/8/6 下午8:50
 */
public class _60第k个排列_回溯 {
    public static void main(String[] args) {
//        System.out.println(getPermutation(4, 9));
        System.out.println(getPermutation(9, 278621));
//        System.out.println(getPermutation(3, 3));
    }

    // 统计 到 k次
    private static int count = 0;
    // 结果
    private static String result = null;
    // 1～N 的查找表
    private static int[] factorial;

    /*
        深搜 + 剪枝 + 回溯
            全排列
            数字组合
            第K个排列
        剪枝 形式不唯一，只要剪好枝
    */
    public static String getPermutation(int n, int k) {
        // 统计
        count = k;
        // 计算 1～N 的 !N
        countNFactorial(n);
        // 路径
        List<Integer> path = new ArrayList<>();
        dfs(path, 0, n);
        return result;
    }

    /**
     * 求 N 阶乘
     *
     * @param n
     */
    private static void countNFactorial(int n) {
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    /**
     * 深搜 + 剪枝
     *
     * @param path
     * @param index
     * @param n
     */
    private static void dfs(List<Integer> path, int index, int n) {
        if (result != null || count < 0) return;

        if (index == n) {
            if (--count == 0) {
                result = coverToString(path);
                return;
            }
        }

        int current = factorial[n - index - 1];
        for (int i = 1; i <= n; i++) {
            if (path.contains(i)) {
                continue;
            }
            // 剪枝 根据 树的层数进行 求 数量是不是在当前分支，不在直接剪枝 跳过
            if (current < count) {
                count -= current;
                continue;
            }

            path.add(i);
            dfs(path, index + 1, n);
            path.remove((Integer) i);
        }
    }

    /**
     * 路径 转 字符串
     *
     * @param path
     * @return
     */
    private static String coverToString(List<Integer> path) {
        StringBuilder builder = new StringBuilder();
        for (Integer num : path) {
            builder.append(num);
        }
        return builder.toString();
    }
}
