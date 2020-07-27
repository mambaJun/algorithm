package com.jun._13罗马数组转整数;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jun
 * @date 2020/7/22 上午8:03
 */
public class _13罗马数组转整数 {
    public static void main(String[] args) {
        System.out.println(romanToInt("II"));

    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int n = s.length();
        int num = map.get(s.charAt(n - 1));

        for (int i = n - 2; i >= 0; i--) {
            Integer left = map.get(s.charAt(i));
            Integer right = map.get(s.charAt(i + 1));
            num = left < right ? num - left : num + left;
        }

        return num;
    }
}
