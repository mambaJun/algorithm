package com.jun._17电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jun
 * @date 2020/7/28 下午10:23
 */
public class _17电话号码的字母组合_回溯法 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }


    /*
    这道题先在纸上比划的时候觉得挺简单的，但是在开始构思代码实现的时候出现了一个棘手问题
    比如
    1位 digits = "2"
    for (int i = 0; i < n; i++) {
        // 添加
    }

    2位 digits = "23"
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            // 添加
        }
    }

    3位 digits = "234"
    for (int i = 0; i < l; i++) {
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < n; k++) {
                // 添加
            }
        }
    }

    如何根据位数增加 for 层数？？？？？
    这个问题导致之前的构思 失败，不能实现

    这里采用递归，将不定的循环转化成 递归，自动到了出口，结束
    这里可以看作一类问题：不定循环数问题 -> 递归化
    */

    // 存 字母
    private static Map<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    private static List<String> result = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
//        map.put('2', "abc");
//        map.put('3', "def");
//        map.put('4', "ghi");
//        map.put('5', "jkl");
//        map.put('6', "mno");
//        map.put('7', "pqrs");
//        map.put('8', "tuv");
//        map.put('9', "wxyz");
        if (digits.length() == 0) {
            return result;
        }
        combinations("", digits);
        return result;
    }


    private static void combinations(String combination, String next_digits) {
//        System.out.printf("%s\t\t%s\n", combination, next_digits);
        if (next_digits.length() == 0) {
            result.add(combination);
            return;
        }

        String letters = map.get(next_digits.charAt(0));

        for (int i = 0; i < letters.length(); i++) {
            combinations(combination + letters.substring(i, i + 1), next_digits.substring(1));
        }
    }

}
