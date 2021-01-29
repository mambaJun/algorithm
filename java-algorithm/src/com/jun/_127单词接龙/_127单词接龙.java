package com.jun._127单词接龙;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jun
 * @date 2020/11/5 下午5:40
 */
public class _127单词接龙 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }
}


class Solution {
    private int flag = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0) {
            return 0;
        }

        Deque<String> queue = new LinkedList<>();
        queue.addLast(beginWord);


        bfs(queue, endWord, wordList, new boolean[wordList.size()]);

//        return queue.getLast().equals(endWord) ? queue.size() : 0;
        return flag == Integer.MAX_VALUE ? 0 : flag;
    }

    void bfs(Deque<String> queue, String endWord, List<String> wordList, boolean[] used) {

//        System.out.println(queue.toString());

        if (queue.getLast().equals(endWord)) {
            flag = Math.min(flag, queue.size());
            return;
        }

//        if (onlyOneChar(queue.getLast(), endWord)) {
//            queue.addLast(endWord);
//            flag = Math.min(flag, queue.size());
//            return;
//        }

        int size = wordList.size();
        for (int i = 0; i < size; i++) {
            String str = wordList.get(i);
//            System.out.println(str);
            if (used[i] == true || !onlyOneChar(queue.getLast(), str)) {
                continue;
            }

            used[i] = true;
            queue.addLast(str);
            bfs(queue, endWord, wordList, used);
            queue.removeLast();
            used[i] = false;
        }
    }

    boolean onlyOneChar(String source, String target) {
        int sourceLen = source.length();
        int targetLen = target.length();

        if (sourceLen != targetLen) {
            return false;
        }

        int count = 0;

        while (sourceLen > 0 && targetLen > 0) {
            if (count > 1) {
                return false;
            }
            if (source.charAt(sourceLen - 1) != target.charAt(targetLen - 1)) {
                count++;
            }
            sourceLen--;
            targetLen--;
        }
        return count == 1;
    }
}