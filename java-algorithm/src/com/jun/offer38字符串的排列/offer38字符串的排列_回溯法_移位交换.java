package com.jun.offer38字符串的排列;

import java.util.*;

/**
 * @author Jun
 * @date 2021/2/12 下午6:26
 */
public class offer38字符串的排列_回溯法_移位交换 {
    public static void main(String[] args) {
        Solution solution = new offer38字符串的排列_回溯法_移位交换.Solution();
        String s = "abc";
        System.out.println(Arrays.deepToString(solution.permutation(s)));
    }

    /*private static class Solution {
        List<String> res = new LinkedList<>();
        char[] c;
        public String[] permutation(String s) {
            c = s.toCharArray();
            dfs(0);
            return res.toArray(new String[res.size()]);
        }
        void dfs(int x) {
            if(x == c.length - 1) {
                res.add(String.valueOf(c)); // 添加排列方案
                return;
            }
            HashSet<Character> set = new HashSet<>();
            for(int i = x; i < c.length; i++) {
                if(set.contains(c[i])) continue; // 重复，因此剪枝
                set.add(c[i]);
                swap(i, x); // 交换，将 c[i] 固定在第 x 位
                dfs(x + 1); // 开启固定第 x + 1 位字符
                swap(i, x); // 恢复交换
            }
        }
        void swap(int a, int b) {
            char tmp = c[a];
            c[a] = c[b];
            c[b] = tmp;
        }
    }*/

    private static class Solution {
        List<String> result = new LinkedList<>();
        char[] chars;

        public String[] permutation(String s) {
            chars = s.toCharArray();
            // 开始固定第 0 位
            dfs(0);

            return result.toArray(new String[result.size()]);
        }

        private void dfs(int x) {
            if (x == chars.length - 1) {
                result.add(String.valueOf(chars));
                return;
            }

            HashSet<Character> set = new HashSet<>();
            // 开始固定第 x 位
            for (int i = x; i < chars.length; i++) {
                // 重复，剪枝
                if (set.contains(chars[i])) {
                    continue;
                }

                set.add(chars[i]);
                // 交换，将 chars[i] 固定在 x 位
                swap(i, x);
                // 开始固定第 x + 1 位
                dfs(x + 1);
                // 恢复交换
                swap(i, x);
            }
        }

        private void swap(int i, int x) {
            char tmp = chars[i];
            chars[i] = chars[x];
            chars[x] = tmp;
        }
    }

    public int majorityElement(int[] nums) throws Exception {
        if (nums == null || nums.length == 0) throw new Exception("nums is null or nums length is zero");
        int count = 0;
        int x = nums[0];

        for (int num : nums) {
            count += x == num ? 1 : -1;
            if (count == 0) {
                x = num;
            }
        }


        return x;
    }
}


