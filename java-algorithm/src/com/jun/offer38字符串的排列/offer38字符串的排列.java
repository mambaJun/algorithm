package com.jun.offer38字符串的排列;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jun
 * @date 2021/2/12 下午6:16
 */
public class offer38字符串的排列 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aab";
        System.out.println(Arrays.deepToString(solution.permutation(s)));
    }
}

class Solution {
    List<String> result = new LinkedList<>();
    String s;

    public String[] permutation(String s) {
        if (s == null) return new String[0];

        this.s = s;
        int n = s.length();
        Deque<Integer> path = new LinkedList<>();
        // 可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
        boolean[] used = new boolean[n];
        dfs(path, n, used);

        return result.toArray(new String[result.size()]);
    }

    void dfs(Deque<Integer> path, int k, boolean[] used) {
        if (k == 0) {
            result.add(indexToString(path));
            return;
        }

        int n = s.length();

        for (int i = 0; i < n; i++) {

            if (i > 0 && s.charAt(i) == s.charAt(i - 1) && !used[i - 1]) {
                continue;
            }
            if (path.contains(i)) {
                continue;
            }
            path.addLast(i);
            used[i] = true;
            dfs(path, k - 1, used);
            used[i] = false;
            path.removeLast();
        }
    }

    String indexToString(Deque<Integer> path) {
        StringBuilder builder = new StringBuilder();

        for (int index : path) {
            builder.append(s.charAt(index));
        }

        return builder.toString();
    }
}
