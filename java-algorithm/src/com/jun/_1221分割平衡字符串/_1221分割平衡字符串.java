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
//        String s = "LLLLRRRR";

        System.out.println(balancedStringSplit(s));
    }

    public static int balancedStringSplit(String s) {
        int count = 0;
        if (s == null || s.length() == 0) return count;

        int n = s.length();
        // 字符串起点
        int start = 0;
        // 左边 数量
        int left = 0;
        // 右边数量
        int right = 0;
        // false-左       true-右
        boolean flag = false;

        char mark = s.charAt(0);

        for (int i = 0; i < n && start < n; i++) {
            char ch = s.charAt(i);
            // 左 到 右
            if (ch != mark && !flag) {
                right = 1;
                flag = true;
                mark = ch;
                continue;
            }
            // 右 到 左
            if ((ch != mark || left < right) && flag) {
                count++;
                mark = ch;
                System.out.println(s.substring(start, start + left + right));
                start += left + right;
                left = 1;
                right = 0;
                flag = false;
                continue;
            }

            //  左
            if (ch == mark && !flag) {
                left++;
                continue;
            }
            //  右
            if (ch == mark && flag) {
                right++;
                continue;
            }
        }

        if (left > 0 && right > 0) {
            System.out.println(s.substring(start, start + left + right));
            count++;
        }

        return count;
    }
}
