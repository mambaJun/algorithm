package com.jun.offer46把数字翻译成字符串;

import java.util.*;

/**
 * @author Jun
 * @date 2021/2/13 下午10:47
 */
public class offer46把数字翻译成字符串 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.translateNum(12238));
        //    String[] letter = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    }


}

class Solution {
    char[] letter;
    int count = 0;
    public int translateNum(int num) {
        letter = getLetter();

        if (num <= 0) return 0;
        List<Integer> nums = new LinkedList<>();

        while (num > 0) {
            nums.add(num % 10);
            num /= 10;
        }

        dfs(nums, 0, new LinkedList<>());


        return count;
    }

    void dfs(List<Integer> nums, int start, Deque<Integer> path) {
        if (k == nums.size()) {
            count++;
            return;
        }

        for (int i = start; i < nums.size(); i++) {
            if (i < nums.size() - 1) {

            }
        }

    }

    private char[] getLetter() {
        char[] letter = new char['z' - 'a' + 1];
        char start = 'a';
        while (start <= 'z') {
            letter[start - 'a'] = start++;
        }
        return letter;
    }
}
