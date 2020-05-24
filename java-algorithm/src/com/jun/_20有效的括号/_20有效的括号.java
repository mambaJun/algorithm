package com.jun._20有效的括号;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 *
 * @author Jun
 * @date 2020/3/31 下午8:51
 */
public class _20有效的括号 {
    /**
     * 2. 利用栈的特点，左符号就进栈，右符号出栈，最后栈是否为空。空则是，不空就不是
     * 3. 对2优化，当遇到右符号时栈内无匹配就是不符合
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {


        if (s == null || s.length() == 0) {
            return true;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Deque deque = new ArrayDeque();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                deque.push(ch);
                continue;
            }
            if (deque.size() == 0 || map.get(ch) != deque.pop()) {
                return false;
            }
        }
        return deque.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
