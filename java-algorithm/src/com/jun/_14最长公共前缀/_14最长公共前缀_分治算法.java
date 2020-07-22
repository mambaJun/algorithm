package com.jun._14最长公共前缀;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/7/22 上午8:30
 */
public class _14最长公共前缀_分治算法 {

    public static void main(String[] args) {
        String[] strs = {
                "flower", "flow", "flight"
        };
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private static String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }

        int mid = (start + end) / 2;
        String leftPrefix = longestCommonPrefix(strs, start, mid);
        String rightPrefix = longestCommonPrefix(strs, mid + 1, end);
        return commonPrefix(leftPrefix, rightPrefix);
    }

    private static String commonPrefix(String leftPrefix, String rightPrefix) {
        int n = Math.min(leftPrefix.length(), rightPrefix.length());
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (leftPrefix.charAt(i) != rightPrefix.charAt(i)) {
                break;
            }
            index++;
        }
        return index == 0 ? "" : leftPrefix.substring(0, index);
    }
}
