package com.jun._17电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jun
 * @date 2020/7/28 下午10:23
 */
public class _17电话号码的字母组合 {

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
    private static Map<Character, String> map = new HashMap<>();
    private static List<String> result = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        combinations(digits, 0);
        return result;
    }

    /**
     * @param digits 输入的字符串
     * @param index  字符串中第几个 字符
     * @return
     */
    private static void combinations(String digits, int index) {
        // 出口 返回
        if (index >= digits.length()) return;

        // 本次处理中，对应的字符串
        String str = map.get(digits.charAt(index));

        // 如果是第一次 ，直接填数据 , 不然填数据就要在 上一次处理的基础上 求结果
        if (result.size() == 0) {
            for (int i = 0; i < str.length(); i++) {
                result.add(str.substring(i, i + 1));
            }
        } else {
            List<String> tmpResult = new ArrayList<>();
            for (int i = 0; i < result.size(); i++) {
                for (int j = 0; j < str.length(); j++) {
                    tmpResult.add(result.get(i) + str.substring(j, j + 1));
                    // 多用 substring 少用 chatAt
//                    tmpResult.add(result.get(i) + str.charAt(j));
                }
            }
            result = tmpResult;
        }

        combinations(digits, index + 1);
    }

}
