package com.jun.面试题0804幂集;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入： nums = [1,2,3]
 * 输出：
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-set-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/9/17 下午7:03
 */
public class 面试题0804幂集 {
    public static void main(String[] args) {
        面试题0804幂集 mian = new 面试题0804幂集();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = mian.subsets(nums);
        for (List<Integer> subset : subsets) {

            for (Integer integer : subset) {
                System.out.printf("%d ", integer);
            }
            System.out.println();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        dfs(res, new LinkedList<>(), nums, 0);

        return res;
    }

    public void dfs(List<List<Integer>> res, Deque<Integer> path, int[] nums, int begin) {
        int len = nums.length;
        if (begin == len) return;

        for (int i = begin; i < len; i++) {
            path.addLast(nums[i]);
            res.add(new ArrayList<>(path));

            dfs(res, path, nums, i + 1);

            path.removeLast();
        }
    }

}
