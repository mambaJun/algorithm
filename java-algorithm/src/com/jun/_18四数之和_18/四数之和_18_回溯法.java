package com.jun._18四数之和_18;

import com.jun.util.ArrayUtil;

import java.util.*;

/**
 * 给定一个包含n 个整数的数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c和 d，使得a + b + c + d的值与target相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * @author Jun
 * @date 2020/1/11 上午12:44
 */
public class 四数之和_18_回溯法 {
    public static void main(String[] args) {
//        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
//        int target = -11;
        int[] nums = {-1, -5, -5, -3, 2, 5, 0, 4};
        int target = -7;
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        int target = 0;
        Solution solution = new Solution();
        System.out.println(solution.fourSum(nums, target).toString());
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n;
        if (nums == null || (n = nums.length) == 0) return res;
        Arrays.sort(nums);
        dfs(res, 0, target, 0, nums, new LinkedList<>(), new boolean[n]);
        return res;
    }

    public void dfs(List<List<Integer>> res, int k, int target, int begin, int[] nums, Deque<Integer> path, boolean[] used) {
        if (k == 4) {
            res.add(new ArrayList<>(path));
            return;
        }

        int n = nums.length;
        for (int i = begin; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            /*
                这里 提供一个思路 继续优化，目前只是简单的进行 剪枝，还可以根据每一层的时候就 开始详细 剪枝，剪的越详细，优化的效果越明显，这也就是体现了 回溯法的优越性
                if (k == 0 && i + 3 < n && target - nums[i] - nums[i + 1] - nums[i + 2] - nums[n - 1] > 0) return;
                if (k == 1 && i + 2 < n && target - nums[i] - nums[i + 1] - nums[n - 1]> 0) return;
                if (k == 2 && i + 1 < n && target - nums[i] - nums[n - 1] > 0) return;
            */
            if (k == 3 && (target - nums[i] != 0)) continue;
            path.addLast(nums[i]);
            used[i] = true;
            dfs(res, k + 1, target - nums[i], i + 1, nums, path, used);
            used[i] = false;
            path.removeLast();
        }
    }
}