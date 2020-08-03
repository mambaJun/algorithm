package com.jun._39组合总和;

import java.util.*;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/8/3 上午10:06
 */
public class _39组合总和 {
    public static void main(String[] args) {
//        int[] candidates = {2, 3, 6, 7};
//        int target = 7;

        int[] candidates = {2, 3, 5};
        int target = 8;

        List<List<Integer>> lists = combinationSum(candidates, target);
        for (List<Integer> list : lists) {
            for (Integer num : list) {
                System.out.printf("%d ", num);
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();

        Arrays.sort(candidates);

        dfs(result, path, 0, candidates, target, 0);

        return result;
    }

    private static void dfs(List<List<Integer>> result, Deque<Integer> path, int count, int[] candidates, int target, int begin) {
        int sum = sum(path);
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

/*
    这个结果 是 去重之前的结果
    2 2 2 2
    2 3 3
    3 2 3
    3 3 2
    3 5
    5 3

    这个结果 是 去重之后的结果
    2 2 2 2
    2 3 3
    3 5

    原因出在那个地方？
        这个题目使用的是深度优先搜索 + 剪枝
        比如第一个选择了 2 ，后面还有 2 3 6 7四种组合，也就是 i 的初始值 i = 0
        找到了重复的原因了，怎么处理？
        前提：candidates 是一个有序
        因为 一个数字可以使用 无数次，所以我们可以 往下一层的时候，从 当前元素位置 往后 组合，就不会出现和 前面组合的 重复现象

    for (int i = 0; i < candidates.length; i++) {
        // 通过排序后不符合的直接剪枝掉
        if (sum + candidates[i] > target) {
            break;
        }
        path.addLast(candidates[i]);
        dfs(result, path, count + 1, candidates, target,i);
        path.removeLast();
    }
*/


        for (int i = begin; i < candidates.length; i++) {
            // 通过排序后可以考虑是不是可以 用 break
            if (sum + candidates[i] > target) {
                break;
            }
            path.addLast(candidates[i]);
            dfs(result, path, count + 1, candidates, target, i);
            path.removeLast();
        }
    }

    private static int sum(Deque<Integer> path) {
        int sum = 0;
        for (Integer num : path) {
            sum += num;
        }
        return sum;
    }
}
