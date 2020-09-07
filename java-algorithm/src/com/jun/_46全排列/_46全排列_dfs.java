package com.jun._46全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jun
 * @date 2020/7/31 下午11:21
 */
public class _46全排列_dfs {
    public static void main(String[] args) {
        List<List<Integer>> list = permute(new int[]{1, 2, 3});
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.printf("%d ", integer);
            }
            System.out.println();
        }
    }



    /*
        深度优先搜索 + 回溯法

        回溯法的小结：
            当前一步是在上一步的基础上进行的，
            但是回溯后，也就是回到上一步，步骤上，而是 恢复到上一步的所有状态，比如此题中的 index 和 list （状态变量） 状态重置
        此题 和 22括号生成 一样
        从 初始 状态 [] 开始 深搜，同时 将不符合 的情况 终止
        举例 [1,2,3]
        从左往右可以看作一个 树，判断是否符合条件，符合继续，不符合，直接终止 （剪枝）


                    1
                1   2
                    3
                    1
            1   2   2
                    3
                    1
                3   2
                    3
                    1
                1   2
                    3
                    1
        []  2   2   2
                    3
                    1
                3   2
                    3
                    1
                1   2
                    3
                    1
            3   2   2
                    3
                    1
                3   2
                    3
         0  1   2   3   index
    */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(new ArrayList<>(), 0, nums.length, nums,result);
        return result;
    }

    /**
     * 深搜 + 回溯 + 剪枝
     * @param list  当前情况 集合
     * @param index 第几步 （状态变量）
     * @param n     共几步（状态变量）
     * @param nums  所有情况
     */
    // 优化版本
    private static void dfs(List<Integer> list, int index, int n, int[] nums,List<List<Integer>> result) {
        // 出口
        if (index == n) {
            // 满足条件， 添加到结果集 这里如果不 重新创建 一个新的 list 由于指针是同一个， list.remove()导致 结果集中的 数据 remove
            result.add(list);
            return;
        }

        for (Integer num : nums) {
            // 剪枝
            if (!list.contains(num)) {
                // 添加 元素
                ArrayList<Integer> newList = new ArrayList<>(list);
                newList.add(num);
                dfs(newList, index + 1, n, nums,result);
            }
        }
    }
/*    private static void dfs(List<Integer> list, int index, int n, int[] nums) {
        // 出口
        if (index == n) {
            // 满足条件， 添加到结果集 这里如果不 重新创建 一个新的 list 由于指针是同一个， list.remove()导致 结果集中的 数据 remove
            result.add(new ArrayList<>(list));
            return;
        }

        for (Integer num : nums) {
            // 剪枝
            if (!list.contains(num)) {
                // 添加 元素
                list.add(num);
                dfs(list, index + 1, n, nums);
                // 恢复到之前状态
                // 回溯
                list.remove(num);
            }
        }
    }*/
}
