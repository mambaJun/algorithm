package com.jun._336回文对;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["abcd","dcba","lls","s","sssll"]
 * 输出: [[0,1],[1,0],[3,2],[2,4]]
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 示例 2:
 * <p>
 * 输入: ["bat","tab","cat"]
 * 输出: [[0,1],[1,0]]
 * 解释: 可拼接成的回文串为 ["battab","tabbat"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/8/6 上午9:30
 */
public class _336回文对 {
    public static void main(String[] args) {
        String[] words = {
                "abcd", "dcba", "lls", "s", "sssll"
        };

        List<List<Integer>> lists = palindromePairs(words);
        print(lists);
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;

                if (isPalindrome(words[i] + words[j])) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 == len2) {
            return isPalindrome(str1 + str2);
        }

        if (len1 > len2) {
            if (!isPalindrome(str1.substring(len2))) {
                return false;
            }
            return isPalindrome(str1.substring(0, len2) + str2);
        }

        if (len1 < len2) {
            if (!isPalindrome(str2.substring(len1))) {
                return false;
            }
            return isPalindrome(str2.substring(0, len1) + str1);
        }
        return true;
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static void print(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.printf("[");
            for (Integer index : list) {
                System.out.printf("%d ", index);
            }
            System.out.printf("]");
            System.out.println();
        }
    }
}
