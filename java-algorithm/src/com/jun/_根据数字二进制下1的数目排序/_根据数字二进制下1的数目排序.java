package com.jun._根据数字二进制下1的数目排序;

/**
 * @author Jun
 * @date 2020/11/6 下午12:18
 */
public class _根据数字二进制下1的数目排序 {
    public static void main(String[] args) {
        Integer.bitCount(19);
    }
}

class Solution {
    public int[] sortByBits(int[] arr) {
        return null;
    }

    int oneInBits(int num) {
        int count = 0;

        while (num > 0) {
            if (num % 2 == 1) count++;
            num /= 2;
        }

        return count;
    }
}
