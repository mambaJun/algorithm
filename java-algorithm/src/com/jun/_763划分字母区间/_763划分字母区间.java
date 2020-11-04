package com.jun._763划分字母区间;

import java.util.*;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *  
 * <p>
 * 提示：
 * <p>
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: Jun
 * @date: 2020/10/22 9:24
 */
public class _763划分字母区间 {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s).toString());
    }

    private static List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();

        int n = S.length();
        /*
        贪心思路：
            边界指针：每次试探后的位置
            试探指针：从当前值向后试探，查看是否可以 把边界指针继续后移，来获取最终结果
        */

        for (int i = 0; i < n; i++) {

            // 已经 试探过的字符 集合，避免后面重复试探
            Set<Character> set = new HashSet<>();
            int start = i;
            int end = i;

            int probe = i;

            char ch = S.charAt(start);
            set.add(ch);
            for (int j = i + 1; j < n; j++) {
                // 向后更新 边界指针
                if (S.charAt(j) == ch) {
                    end = j;
                }
            }

            for (int j = i + 1; j < end; j++) {
                char c = S.charAt(j);
                if (!set.contains(c)) {
                    set.add(c);
                    for (int k = j + 1; k < n; k++) {
                        if (S.charAt(k) == c) {
                            end = Math.max(end, k);
                        }
                    }
                }
            }

            res.add(end - start);
            i = end;
        }

        return res;
    }
}