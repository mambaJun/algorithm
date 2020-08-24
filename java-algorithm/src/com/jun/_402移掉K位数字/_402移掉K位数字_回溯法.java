package com.jun._402移掉K位数字;

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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/8/24 上午8:09
 */
public class _402移掉K位数字_回溯法 {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        System.out.println(removeKdigits(num, k));

    }

    private static int min = Integer.MAX_VALUE;

    /*
        回溯法 理论 在效果上可以实现 可惜超时了
    */
    public static String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) {
            return min + "";
        }

        Deque<Integer> path = new LinkedList<>();
        remove(path, num, num.length() - k, 0);

        return min + "";
    }

    public static void remove(Deque<Integer> path, String num, int k, int begin) {
        if (k == 0) {
            int newNum = listToNumber(path, num);
            min = Math.min(min, newNum);
            return;
        }
        int n = num.length();
        for (int i = begin; i < n; i++) {
            path.addLast(i);
            if (listToNumber(path, num) > min) {
                path.removeLast();
                continue;
            }

            remove(path, num, k - 1, i + 1);

            path.removeLast();
        }
    }

    private static int listToNumber(Deque<Integer> list, String num) {
        int result = 0;
        for (Integer index : list) {
            result *= 10;
            result += num.charAt(index) - '0';
        }
        return result;
    }

}
