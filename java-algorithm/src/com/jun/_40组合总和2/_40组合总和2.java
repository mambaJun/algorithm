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
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);
        dfs(res, new LinkedList<>(), candidates, 0, target);
        return res;
    }

    public static void dfs(List<List<Integer>> res, Deque<Integer> path, int[] candidates, int begin, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        int n = candidates.length;
        for (int i = begin; i < n; i++) {
            // 剪枝
            if (target - candidates[i] < 0) {
                break;
            }

            // 在 排序的基础上进行了  和前一个 比较，如果相同 跳过
            // 这里模拟一下 continue 的场景
            /*
                5
                1   2   2   2   5
            i   0   1   2
            b   0   1   2
            p   1   12  122
            此时 1 2 2 都是 i == begin ,也就是当前位置 第一个出现 ，不需要去重，比如 已经将 1 2 2 存入结果集后回退上一步
            i   0   1   2   3   4
            b   0   1   1*  1   1
            p   1   12  12  12  125×
            此时 b = 1, i = 2
            i > b && nums[i] == nums[i - 1] 当前层次的遍历中，
                i > b说明 不是当前层次的第一个了
                nums[i] == nums[i - 1]  当前数值 和上一个数值相同，跳过，不考虑

            b = begin
            p = path
            */
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            dfs(res, path, candidates, i + 1, target - candidates[i]);
            path.removeLast();
        }
    }
}
