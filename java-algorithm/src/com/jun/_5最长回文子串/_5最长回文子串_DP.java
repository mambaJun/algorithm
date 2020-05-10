package com.jun._5最长回文子串;

/**
 * 111111
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/3/31 上午8:32
 */
public class _5最长回文子串_DP {
    /**
     * 定义 一个二维数组，期初 用 i，j来表示下标发现不够直观，然后改成了 i=start ,j=end
     * 从 start -> end，比暴力好的地方在于 曾经 处理的不会再次重复检查
     * 实际上只用到了矩阵的下三角
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        int length = s.length();
        if (length <= 1) {
            return s;
        }

        boolean[][] dp = new boolean[length][length];

        // 记录最长回文字符串的起始位置
        int start = 0;
        // 记录最长回文字符串的长度 -》最终 s.substring(start, start + maxLength) 来确定 最长回文字符串
        int maxLength = 1;

        for (int end = 1; end < length; end++) {
            for (int begin = 0; begin <= end; begin++) {

                if (s.charAt(begin) == s.charAt(end)) {
                    if (end - begin < 3) {
                        dp[begin][end] = true;
                    } else {
                        dp[begin][end] = dp[begin + 1][end - 1];
                    }
                }

                if (dp[begin][end] && end - begin + 1 > maxLength) {
                    maxLength = end - begin + 1;
                    start = begin;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String text1 = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth".toUpperCase();
        System.out.println(longestPalindrome(text1));
    }

}