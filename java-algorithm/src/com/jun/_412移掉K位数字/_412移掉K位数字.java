package com.jun._412移掉K位数字;

import java.util.Deque;
import java.util.LinkedList;

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
public class _412移掉K位数字 {
    public static void main(String[] args) {
//        String num = "1432219";
        String num = "10200";
        int k = 1;
        System.out.println(removeKdigits(num, k));
    }

    /*
    0123456
    3
    0-3
    1-4
    2-5
    3-6
     */
    public static String removeKdigits(String num, int k) {
        int len = num.length();
        int digit = len - k;
        if (digit == 0) return "0";

        Deque<Character> path = new LinkedList<>();
        dfs(num, digit, 0, path);

        if (path.isEmpty()) return "0";

        StringBuilder builder = new StringBuilder();
        for (Character character : path) builder.append(character);

        return builder.toString();
    }

    private static void dfs(String num, int digit, int begin, Deque<Character> path) {
        if (digit == 0) return;
        int n = num.length();
        char res = '9' + 1;
        for (int i = begin; i < n - digit + 1; i++) {
            char ch = num.charAt(i);

            if (ch < res) {
                res = ch;
                begin = i;
            }
        }
        // 前导 0不入队
        if (path.isEmpty() && res == '0') {

        } else {
            path.addLast(res);
        }
        dfs(num, digit - 1, begin + 1, path);
    }

}
