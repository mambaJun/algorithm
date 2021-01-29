package com.jun._1002查找常用字符;

import java.util.*;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/10/14 下午1:13
 */
public class _1002查找常用字符 {
    public static void main(String[] args) {
        String[] A = {"bella", "label", "roller"};
        System.out.println(commonChars(A).toString());
    }

    public static List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();

        int arrLen = A.length;
        if (A == null || arrLen == 0) return res;

        int[] minfreq = new int['z' - 'a' + 1];
        Arrays.fill(minfreq, Integer.MAX_VALUE);

        for (String s : A) {
            int n = s.length();
            int[] freq = new int['z' - 'a' + 1];
//            for (char c : s.toCharArray()) freq[c - 'a']++;

            char ch = 'a' - 1;
            while (++ch <= 'z') {
                int index = ch - 'a';
                minfreq[index] = Math.min(minfreq[index], freq[index]);
            }
        }

        char ch = 'a' - 1;
        while (++ch <= 'z') {
            int count = minfreq[ch - 'a'];
            while (count-- > 0) {
                res.add(ch + "");
            }
        }

        return res;
    }

    public static List<String> commonChars1(String[] A) {
        List<String> res = new ArrayList<>();

        int arrLen = A.length;
        if (A == null || arrLen == 0) return res;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arrLen; i++) {
            String str = A[i];
            int strLen = str.length();
            if (i == 0) {
                for (int j = 0; j < strLen; j++) {
                    char ch = str.charAt(j);
                    if (map.containsKey(ch)) {
                        map.put(ch, map.get(ch) + 1);
                    } else {
                        map.put(ch, 1);
                    }
                }
            } else {
                char[] chars = new char['z' - 'a' + 1];
                for (int j = 0; j < strLen; j++) {
                    chars[str.charAt(j) - 'a']++;
                }
                Map<Character, Integer> newMap = new HashMap<>();
                for (Character character : map.keySet()) {
                    if (map.containsKey(character) && chars[character - 'a'] > 0) {
                        newMap.put(character, Math.min(map.get(character), chars[character - 'a']));
                    }
                }
                map = newMap;
            }
        }

        for (char key : map.keySet()) {
            int num = map.get(key);
            while (num-- > 0) res.add(key + "");
        }

        return res;
    }
}
