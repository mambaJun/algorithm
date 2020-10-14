package com.jun._1_test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Delete {
    public static void main(String[] args) {
//        String s = "bcabc";   // "acdb"
        String s = "cbacdcbc";   // "acdb"
        /*
            cbacdcbc
            0 1 2 3
            a b c d
            1 2 3 1
            c
            b
            a
            ac
            acd
            acdc -> acd
            acdb
            acdbc -> acdb

            ecbacba
            0 1 2 3 4
            a b c d e
            2 2 2 0 0
            e
            ec
            ecb


         */
        System.out.println(smallestSubsequence(s));
    }

    public static String smallestSubsequence(String s) {
        int length = s.length();
        if (s == null || length == 0) return s;

        int size = 'z' - 'a' + 1;
        // 统计 每个字符出现的次数，用于判断出栈时，当前字符 是否是最后一个 字符
        int[] count = new int[size];
        // 标记 当前字符的是否已经确定了，如果确定了顺序，后面的再出现可以直接跳过了
        boolean[] flags = new boolean[size];

        for (int i = 0; i < length; i++) count[s.charAt(i) - 'a']++;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            // 当前字符 数量 -1
            count[index]--;
            /*
                对于此处的 flags[index] == true 就 continue ，一直有个错觉，如果当前字符 已经在 栈中出现了，怎么办，是不是要删除栈中的那个字符，换上当前位置的 字符
                理解：
                    通过下面的入栈 和 出栈 规则 已经可以 保证 字符串的 字典序 规则，字符在 栈中没有出栈就说明 那个字符的位置是可以的，后面再出现的话，就可以直接跳过，忽略了
             */
            if (flags[index]) continue;
            // !stack.isEmpty()                 栈 非空
            // stack.peek() > c                 栈顶 元素 大于 当前元素的
            // count[stack.peek() - 'a'] > 0    栈顶 元素 不是 最后一次，在后面 还会出现
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                flags[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            flags[index] = true;
        }

        StringBuilder builder = new StringBuilder();
        for (Character character : stack) builder.append(character);

        return builder.toString();
    }
}