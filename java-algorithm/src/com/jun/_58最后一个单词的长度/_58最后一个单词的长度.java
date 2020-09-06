package com.jun._58最后一个单词的长度;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/7/22 下午12:05
 */
public class _58最后一个单词的长度 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a "));

    }

    public static int lengthOfLastWord(String s) {
        if (s == null || "".equals(s.trim())) {
            return 0;
        }

        s = s.trim();

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }

    public static int lengthOfLastWord1(String s) {
        if (s == null || "".equals(s.trim())) {
            return 0;
        }

        int start = s.length() - 1;
        for (; start >= 0; start--) {
            if (s.charAt(start) != ' ') {
                break;
            }
        }
        int count = 0;
        for (int i = start; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }
}
