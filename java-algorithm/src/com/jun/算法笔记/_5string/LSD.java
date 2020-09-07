package com.jun.算法笔记._5string;

/**
 * 低位优先的字符串排序
 *
 * @author Jun
 * @date 2020/8/31 上午9:27
 */
public class LSD {

    public static void main(String[] args) {
        String[] a = {"DADDDD", "ACAAAAA", "CACCC", "BFEBB", "GACBGG"};
        int w = 3;
        sort(a, w);
        print(a);
    }

    private static void print(String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.printf("%s ", a[i]);
        }
        System.out.println();
    }

    public static void sort(String[] a, int w) {
        int n = a.length;
        int R = 7;
        String[] aux = new String[n];
        for (int d = w - 1; d >= 0; d--) {
            // 根据第 i 个字符用键索引计数法 排序
            int[] count = new int[R + 1];
            // 计算出现的频率
            for (int i = 0; i < n; i++) {
                count[a[i].charAt(d) - 'A' + 1]++;
            }
            // 将频率 转换为 索引
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }
            // 将元素分类
            for (int i = 0; i < n; i++) {
                aux[count[a[i].charAt(d) - 'A']++] = a[i];
            }
            // 回写
            for (int i = 0; i < n; i++) {
                a[i] = aux[i];
            }
            print(a);
        }
    }
}
