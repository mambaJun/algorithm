package com.jun.进制转换;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Jun
 * @date 2020/5/2 下午1:26
 */
public class 进制转换 {

    private void convert(int n, int base) {
        Stack<Character> stack = new Stack<>();
        final char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        while (n > 0) {
            stack.push(digit[n % base]);
            n /= base;
        }
        while (!stack.isEmpty()) {
            System.out.printf("%c",stack.pop());
        }
    }

    public static void main(String[] args) {
        new 进制转换().convert(8,2);
    }
}
