package com.jun.算法笔记._5string;

/**
 * @author Jun
 * @date 2020/8/31 上午9:35
 */
public class _键索引计数法 {
    public static void main(String[] args) {
        String[] a = {"AC", "CD", "D", "A", "F", "B"};
        int[] keys = {1, 2, 4, 5, 7, 8};

        int n = a.length;
        String[] aux = new String[n];
        int R = 'z' - 'a';
        int[] count = new int[R + 1];

        for (int i = 0; i < n; i++) {
            count[keys[i] + 1]++;
        }
        for (int r = 0; r < R; r++) {
            count[r + 1] += count[r];
        }
        for (int i = 0; i < n; i++) {
            aux[count[keys[i]]++] = a[i];
        }
        for (int i = 0; i < n; i++) {
            a[i] = aux[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%s ", a[i]);
        }
        System.out.println();
    }
}
