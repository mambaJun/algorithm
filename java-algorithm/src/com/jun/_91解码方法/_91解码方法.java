package com.jun._91解码方法;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/5/11 下午11:49
 */
public class _91解码方法 {

    public static int numDecodings(String s) {
        if (s == null) {
            return 0;
        }
        int length = s.length();
        if (length < 2) {
            return Integer.parseInt(s) == 0 ? 0 : 1;
        }
        int sum = 1;
        for (int i = 0; i < length - 1; i++) {
            sum += Integer.parseInt(s.substring(i, i + 1)) > 26 ? 0 : 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        String string = "12";
        System.out.println(numDecodings(string));
    }


}
