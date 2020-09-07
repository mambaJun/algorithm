package com.jun._40组合总和2;

import java.util.*;

/**
 * @author Jun
 * @date 2020/8/3 上午11:55
 */
public class _40组合总和2 {

    public static void main(String[] args) {
//        int[] candidates = {2, 3, 6, 7};
//        int target = 7;

//        int[] candidates = {2, 3, 5};
//        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int[] candidates = {2, 5, 2, 2, 1};

        int target = 5;

        List<List<Integer>> lists = combinationSum2(candidates, target);
        for (List<Integer> list : lists) {
            for (Integer num : list) {
                System.out.printf("%d ", num);
            }
            System.out.println();
        }
    }

    /*
        和 46 、47 很像

        begin 去重复

        同一路径中去重
        if (i > begin && candidates[i] == candidates[i - 1]) {
            continue;
        }
        画图更直观，下面可以看就参考，不能看，就直接画个
        https://mm.edrawsoft.cn/map.html?obj=qq4AEA76740CF6492664B70B27719219F8/Personal/%E6%9C%AA%E5%91%BD%E5%90%8D%E6%96%87%E4%BB%B61.emmx
    */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序
        Arrays.sort(candidates);
        int length = candidates.length;
        dfs(result, candidates, target, new ArrayDeque<>(), length, 0);
        return result;
    }

    private static void dfs(List<List<Integer>> result, int[] candidates, int target, Deque<Integer> path, int n, int begin) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < n; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            // 在 排序的基础上进行了  和前一个 比较，如果相同 跳过
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            dfs(result, candidates, target - candidates[i], path, n, i + 1);
            path.removeLast();
        }
    }
}
