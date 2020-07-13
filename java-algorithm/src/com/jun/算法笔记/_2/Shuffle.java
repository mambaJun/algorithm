package com.jun.算法笔记._2;

import java.util.Random;

/**
 * @author Jun
 * @date 2020/7/13 下午8:56
 */
public class Shuffle {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        shuffle(nums);
        print(nums);
    }

    private static void shuffle(int[] nums) {
        int n = nums.length;
        Random random = new Random();
        for (int i = 0; i < n; i++) {

            int r = random.nextInt(i + 1);
            exch(nums, i, r);
        }
    }

    private static void exch(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();
    }
}
