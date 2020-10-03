package com.jun._1_test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Delete {

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        Delete delete = new Delete();
        System.out.println(Arrays.toString(delete.test(T)));
        // [1, 1, 4, 2, 1, 1, 0, 0]
    }

    public int[] test(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
            print(T, stack);
        }
        return ans;
    }

    private void print(int[] T, Deque<Integer> stack) {
        for (Integer index : stack) {
            System.out.printf("%d ", T[index]);
        }
        System.out.println();
    }
}