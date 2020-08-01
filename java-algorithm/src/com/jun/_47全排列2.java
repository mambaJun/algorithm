package com.jun;

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

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), 0, nums.length, nums);
        return result;
    }

    private static void dfs(List<List<Integer>> result,
                            List<Integer> list,
                            int index,
                            int n,
                            int[] nums) {
        if (index == n) {
            result.add(getNewList(list, nums));
            return;
        }

        for (int i = 0; i < n; i++) {

            // 存在
            if (flags.containsKey(index)) {
                Stack<Integer> stack = flags.get(index);
                if (stack.contains(nums[i])) {
                    continue;
                } else {
                    stack.push(nums[i]);
                }
            } else { // 不存在
                Stack<Integer> stack = new Stack<>();
                stack.push(nums[i]);
                flags.put(index, stack);
            }

            if (list.contains(i)) {
                continue;
            }

            list.add(i);

            dfs(result, list, index + 1, n, nums);

            list.remove((Integer) i);

            if (flags.containsKey(index + 1)) {
                Stack<Integer> stack = flags.get(index + 1);
                stack.clear();
            }
        }
    }


    private static List<Integer> getNewList(List<Integer> list, int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (Integer index : list) {
            result.add(nums[index]);
        }

        System.out.println(result.toString());
        System.out.println("------");
        return result;
    }
}
