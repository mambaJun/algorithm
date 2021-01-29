package com.jun._47全排列2;

import java.util.*;

/**
 * @author Jun
 * @date 2020/8/1 上午9:35
 */
public class _47全排列2 {
    private static List<List<Integer>> result = new ArrayList<>();
    private static Map<Integer, Stack<Integer>> flags = new HashMap<>();

    public static void main(String[] args) {
        List<List<Integer>> lists = permuteUnique(new int[]{1, 1, 2});
        for (List<Integer> list : lists) {
            for (Integer num : list) {
                System.out.printf("%d ", num);
            }
            System.out.println();
        }
    }

    /*
        这道题目的本质上就是 在有效的前提下， 相同元素里面，取第一个元素作为 排序
        可以画图，很直观的可以看出来
    */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        // 这个排序 方便 后面的剪枝，在有序的序列中， 只需要 和 前一项比较
        Arrays.sort(nums);
        dfs(result, nums, 0, length, new boolean[length], path);

        return result;
    }

    private static void dfs(List<List<Integer>> result, int[] nums, int depth, int n, boolean[] used, Deque<Integer> path) {
        // 出口 如果符合条件了，将结果 存入结果集
        if (depth == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            // 如果当前数字已经 被使用了，可以跳过当前，进入下一个数字了，相当于 46 中的 contain
            if (used[i]) {
                continue;
            }

            /*
             这一步最难理解，今天理解了好长时间，最终还是把[1,1,2]这个例子 用手画了一遍，注意，要保证画的时候正确，这样代码就不难理解了
             i > 0   如果 i 是 0 的话，就不用考虑重复问题，考虑重复是后面的 相同数字要考虑的
             nums[i] == nums[i -1] 在i > 0 上，也就是 i - 1有效， 这么做，是在 nums 是有序的基础上，所以 可以在 dfs前将 nums sort 一下
             !used[i- 1] ，即 used[i - 1] == false，这个是 此题对我来说迷惑性最大的，一直不能理解，为啥 是 false的时候，成立
                  比如是 1,1,2
                  nums = {1,1,2} , used = {false, false, false} used 可以代表 下标索引，同时 记录是否在当前 path 中已经使用过了
                          0 1 2              0     1      2
             0                                         []
             1                 1                       1                       2
             2         1       1       2       1       1       2       1       1       2
             3       1 1 2   1 1 2   1 1 2   1 1 2   1 1 2   1 1 2   1 1 2   1 1 2   1 1 2
             可以 过了 上面的 if 说明 不是 同一位置元素了，

             重点来了：
                  如果是 前一个 是 true 说明正在参与当前 path 中没有问题，
                  如果是 false ，说明前面已经有有相同的次序了，可以跳过这个
             */

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // 将 元素 存入路径中
            path.addLast(nums[i]);
            // i 记录 哪个 下标索引是 i的 元素 已经被使用了，true 代表正在使用
            used[i] = true;
            dfs(result, nums, depth + 1, n, used, path);
            // 下面两步是 回溯法，回退到 当前状态
            path.removeLast();
            used[i] = false;
        }
    }
}
