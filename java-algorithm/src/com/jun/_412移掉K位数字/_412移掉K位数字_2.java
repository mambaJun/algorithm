package com.jun._412移掉K位数字;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * <p>
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * <p>
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * <p>
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 * <p>
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/10/14 下午2:37
 */
public class _412移掉K位数字_2 {
    public static void main(String[] args) {
//        String num = "1432219";
//        String num = "10200";
//        int k = 3;
        String num = "9";
        int k = 1;
        System.out.println(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();

        // 入栈，一共出栈  k 次，代表 删除 了 k 个 元素
        for (char digit : num.toCharArray()) {
            //  栈 非空， 还未 删除 k 个元素（k > 0），栈头元素 大于 当前 比较 元素 -》 出栈
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                //  出栈
                stack.removeLast();
                //  个数 减一
                k--;
            }
            //  常规 入栈
            stack.addLast(digit);
        }

        /*
            9       1       栈空 入栈，却没有出栈
            112     1       元素 是 一直递增，没有 满足 出栈的第三个 条件
            这种例子 ，栈空 入栈，却没有出栈，这里做个 收尾 把关的
         */
        while (k-- > 0) stack.removeLast();

        StringBuilder sb = new StringBuilder();

        // 默认 有前导零
        boolean leadingZero = true;
        for (char digit : stack) {
            //  去除前导0
            if (leadingZero && digit == '0') continue;
            leadingZero = false;
            sb.append(digit);
        }

        String res = sb.toString();


        return "".equals(res) ? "0" : res;
    }

}
