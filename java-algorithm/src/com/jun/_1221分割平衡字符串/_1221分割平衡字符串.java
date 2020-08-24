package com.jun._1221分割平衡字符串;

/**
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 * <p>
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * <p>
 * 返回可以通过分割得到的平衡字符串的最大数量。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 2：
 * <p>
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 3：
 * <p>
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s[i] = 'L' 或 'R'
 * 分割得到的每个字符串都必须是平衡字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/8/21 下午9:53
 */
public class _1221分割平衡字符串 {

    public static void main(String[] args) {
//        String s = "RLRRLLRLRL";
//        String s = "RLLLLRRRLR";
        String s = "RLRRRLLRLL";
//        String s = "RLLLLRRRLR";
//        String s = "LLLLRRRR";

        System.out.println(balancedStringSplit(s));
//        System.out.println(balancedStringSplit1(s));
    }

    public static int balancedStringSplit(String s) {
        int count = 0;
        if (s == null || s.length() == 0) return count;

        int n = s.length();

        int balance = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'L') balance++;
            if (ch == 'R') balance--;
            if (balance == 0) count++;
        }

        return count;
    }

    public static int balancedStringSplit1(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int count = 0, diffCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                diffCount++;
            } else {
                diffCount--;
            }
            if (diffCount == 0) {
                System.out.println(s.substring(0, i + 1));
                count++;
            }
        }
        return count;
    }
}
