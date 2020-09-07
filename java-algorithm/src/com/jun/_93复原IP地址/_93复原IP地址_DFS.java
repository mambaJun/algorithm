package com.jun._93复原IP地址;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jun
 * @date 2020/8/9 上午9:46
 */
public class _93复原IP地址_DFS {
    public static void main(String[] args) {
//        String s = "25525511135";
//        String s = "010010";
        // ["0.10.0.10","0.100.1.0"]
        String s = "101023";
        // ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
        List<String> list = restoreIpAddresses(s);
        System.out.println(list.toString());
    }

    /**
     * 深搜 + 剪枝 + 回溯
     *
     * @param s
     * @return
     */
    public static List<String> restoreIpAddresses(String s) {
        int n = s.length();
        List<String> result = new LinkedList<>();
        if (n < 4) return result;

        dfs(result, new ArrayList<>(), s, 0, 4, 0);

        return result;
    }

    /**
     * @param result 结果集
     * @param path   深搜 路径
     * @param str    深搜 对象
     * @param index  深搜的层数
     * @param n      一共多少层
     * @param begin  深搜的起始位置
     */
    private static void dfs(List<String> result, List<String> path, String str, int index, int n, int begin) {
        if (index == n) {
            result.add(pathToString(path));
            return;
        }

        int len = str.length();
        for (int i = begin; i < len; i++) {
            // 每段地址 的长度判断
            if (!isPass(index, len - begin)) return;

            String item = str.substring(begin, index == 3 ? len : i + 1);
            // 每段地址的长度 判断
            if (item.length() > 3) return;

            // 数字判断
            if (!isNumPass(item)) return;

            path.add(item);
            dfs(result, path, str, index + 1, n, begin + item.length());
            // 回溯
            path.remove(index);
            // 如果是 第四段，没必要 循环了，循环会造成 重复
            if (index == 3) break;
        }
    }

    /**
     * 数字是不是 符合
     * 数字不能有前置 0
     *
     * @param item
     * @return
     */
    private static boolean isNumPass(String item) {
        int len = item.length();
        Integer num = Integer.valueOf(item);

        if (len == 2 && num < 10) {
            return false;
        }
        if (len == 3 && num < 100) {
            return false;
        }

        return 0 <= num && num <= 255;
    }

    /**
     * 将 深搜路径 转成结果
     *
     * @param path
     * @return
     */
    private static String pathToString(List<String> path) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            builder.append(path.get(i));
            if (i < 3) {
                builder.append(".");
            }
        }
        return builder.toString();
    }

    /**
     * 当前 深度的 字符长度检查
     * 第一位 [4,12]
     * 第二位 [3,9]
     * 第三位 [2,6]
     * 第四位 [1,3]
     *
     * @param index
     * @param n
     * @return
     */
    private static boolean isPass(int index, int n) {
        switch (index) {
            case 0:
                if (!(4 <= n && n <= 12)) return false;
                break;
            case 1:
                if (!(3 <= n && n <= 9)) return false;
                break;
            case 2:
                if (!(2 <= n && n <= 6)) return false;
                break;
            case 3:
                if (!(1 <= n && n <= 3)) return false;
                break;
        }
        return true;
    }
}
