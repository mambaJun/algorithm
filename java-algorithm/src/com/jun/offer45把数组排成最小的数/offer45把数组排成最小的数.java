package com.jun.offer45把数组排成最小的数;


import java.util.Arrays;

/**
 * @author Jun
 * @date 2021/2/13 下午8:15
 */
public class offer45把数组排成最小的数 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247};
/*

         1399,  4398,   5607,   5703,   6973,   824,    8247,   938,    9609]
        "1399   4398    5607    5703    6973    824     7824    938     9609";

        1399,   4398,   5607,   5703,   6973,   8247,   824,    938,    9609
        1399    4398    5607    5703    6973    8247    824     938     9609
        1399    4398    5607    5703    6973    8247    824     938     9609"
*/
        System.out.println(solution.minNumber(nums));
    }
}

/*class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        System.out.println(Arrays.toString(strs));
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }

    public String minNumber1(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] strings = new String[nums.length];

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        sort(strings);

        System.out.println(Arrays.toString(strings));

        StringBuilder builder = new StringBuilder();

        for (String str : strings) {
            builder.append(str);
        }

        return builder.toString();
    }

    private void sort(String[] strings) {
        int n = strings.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (!compare(strings[j] + strings[j + 1], strings[j + 1] + strings[j])) {
                    swap(strings, j, j + 1);
                }
            }
        }
    }

    private void swap(String[] strings, int index1, int index2) {
        String tmp = strings[index1];
        strings[index1] = strings[index2];
        strings[index2] = tmp;
    }

    boolean compare(String str1, String str2) {

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int str1Len = chars1.length;
        int str2Len = chars2.length;

        int i = 0;
        for (; i < str1Len && i < str2Len; i++) {
            if (chars1[i] == chars2[i]) continue;
            if (chars1[i] != chars2[i]) return chars1[i] - chars2[i] <= 0;
        }
        if (str1Len == str2Len && i == str1Len) {
            return true;
        }

        boolean flag = false;

        if (i != str1Len) {
            flag = chars1[i] < chars2[i - 1];
        } else {
            flag = chars1[i - 1] < chars2[i];
        }

        return flag;
    }

    boolean compare1(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int str1Len = chars1.length;
        int str2Len = chars2.length;

        int i = 0;
        for (; i < str1Len && i < str2Len; i++) {
            if (chars1[i] == chars2[i]) continue;
            if (chars1[i] != chars2[i]) return chars1[i] - chars2[i] <= 0;
        }
        if (str1Len == str2Len && i == str1Len) {
            return true;
        }

        boolean flag = false;

        if (i != str1Len) {
            flag = chars1[i] < chars2[i - 1];
        } else {
            flag = chars1[i - 1] < chars2[i];
        }

        return flag;
    }
}*/

class Solution {
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strings = new String[nums.length];

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        sort(strings, 0, n - 1);

        StringBuilder builder = new StringBuilder();

        for (String str : strings) {
            builder.append(str);
        }

        return builder.toString();
    }

    private void sort(String[] strings, int start, int end) {
        if (start >= end) return;

        int left = start;
        int right = end;

        String str = strings[left];

        while (left < right) {
            while (left < right && (strings[right] + str).compareTo(str + strings[right]) >= 0) {
                right--;
            }
            swap(strings, left, right);
            while (left < right && (strings[left] + str).compareTo(str + strings[left]) <= 0) {
                left++;
            }
            swap(strings, left, right);
        }

        sort(strings, start, left - 1);
        sort(strings, left + 1, end);
    }

    private void swap(String[] strings, int left, int right) {
        String tmp = strings[left];
        strings[left] = strings[right];
        strings[right] = tmp;
    }
}
