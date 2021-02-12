package com.jun._567字符串的排列;

/**
 * @author Jun
 * @date 2021/2/10 下午3:15
 */
public class _567字符串的排列 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(solution.checkInclusion(s1, s2));
    }
}

class Solution {
    /*
        滑动窗口：
        这里的滑动窗口用的 双指针 + 数组（map）组合，
        下面的的这种解题方法挺妙的，事先将 s1 中的每个对应的元素减一，然后用个双指针 和 数组 两个一起模拟 滑动窗口，当窗口长度 等于 s1 长度时候，说明已经出现结果。
     */
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        int[] count = new int['z' - 'a' + 1];
        for (int i = 0; i < n; i++) {
            count[s1.charAt(i) - 'a']--;
        }

        int left = 0;

        for (int right = 0; right < m; right++) {
            int index = s2.charAt(right) - 'a';
            count[index]++;
            while (count[index] > 0) {
                count[s2.charAt(left++) - 'a']--;
            }
            if (right - left + 1 == n) return true;
        }

        return false;
    }
}