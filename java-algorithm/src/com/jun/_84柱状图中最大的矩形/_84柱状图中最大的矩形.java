package com.jun._84柱状图中最大的矩形;

import com.jun.util.MyStack;
import org.omg.CORBA.INTERNAL;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * @author Jun
 * @date 2020/4/4 上午9:06
 */
public class _84柱状图中最大的矩形 {
    public static int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < heights.length; i++) {

            if (stack.peek() < heights[i]) {
                stack.push(heights[i]);
            }

            for (int j = i + 1; j < heights.length; j++) {

                if (heights[i] > heights[j]) {
                    if (i == 0) {
                        stack.push(Math.max(stack.pop(), heights[i] * (j - i + 1)));
                        break;
                    }
                    for (int k = i - 1; k >= 0; k--) {
                        if (heights[k] < heights[i]) {
                            stack.push(Math.max(stack.pop(), heights[i] * (j - k + 1)));
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
