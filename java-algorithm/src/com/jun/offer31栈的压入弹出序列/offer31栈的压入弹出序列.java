package com.jun.offer31栈的压入弹出序列;

/**
 * @author Jun
 * @date 2021/2/5 下午11:12
 */
public class offer31栈的压入弹出序列 {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        Solution solution = new Solution();
        System.out.println(solution.validateStackSequences(pushed, popped));
    }
}

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int m;
        if ((m = pushed.length) != popped.length) {
            return false;
        }

        for (int i = 0; i < m; i++) {
            if (pushed[i] != popped[m - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}