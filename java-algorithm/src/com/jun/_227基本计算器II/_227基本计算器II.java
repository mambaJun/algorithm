package com.jun._227基本计算器II;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Jun
 * @date 2022/3/19 下午10:50
 */
public class _227基本计算器II {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "3+2*2";
        solution.calculate(s);
    }
}

class Solution {
    /*
        +   -   *   /
    i   2   2   4   4
    o   3   3   5   5
    i-in    o-out
    */
    static char ADD = '+';
    static char SUBTRACT = '-';
    static char MULTIPLY = '*';
    static char DIVISION = '/';

    static {
        Map<Character, Integer> inMap = new HashMap<>();
        inMap.put(ADD, 2);
        inMap.put(SUBTRACT, 2);
        inMap.put(MULTIPLY, 4);
        inMap.put(DIVISION, 4);
        Map<Character, Integer> outMap = new HashMap<>();
        outMap.put(ADD, 3);
        outMap.put(SUBTRACT, 3);
        outMap.put(MULTIPLY, 5);
        outMap.put(DIVISION, 5);
    }

    public int calculate(String s) {
        Stack<Character> stack = new Stack<>();
        // TODO 模拟 栈在 后缀表达式的应用
        return 0;
    }
}