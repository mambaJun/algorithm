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
public class _336回文对_trie {
    public static void main(String[] args) {
        String[] words = {
                "abcd", "dcba", "lls", "s", "sssll"
        };

        List<List<Integer>> lists = palindromePairs(words);
        print(lists);
    }

    private Node root = new Node();

    public static List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        // 字典树的插入，注意维护每个节点上的两个列表
        for (int i = 0; i < n; i++) {
            String rev = new StringBuilder(words[i]).reverse().toString();
//            Node current = root;
//            if (isPalindrome(rev.substring(0))) {
//                current.suffixs.add(i);
//            }
        }


        List<List<Integer>> result = new ArrayList<>();

        return result;
    }

    class Node {
        public Node[] children;
        public List<Integer> words;
        public List<Integer> suffixs;

        public Node() {
            this.children = new Node['z' - 'a' + 1];
            this.words = new ArrayList<>();
            this.suffixs = new ArrayList<>();
        }
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
