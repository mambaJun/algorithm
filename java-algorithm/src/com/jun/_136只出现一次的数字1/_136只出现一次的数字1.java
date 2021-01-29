package com.jun._136只出现一次的数字1;

/**
 * @author Jun
 * @date 2020/10/19 下午6:43
 */
public class _136只出现一次的数字1 {

    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 3};
        int count = 0;

        System.out.println(3 ^ 3);
        System.out.println(0 ^ 3);
        System.out.println(3 ^ 0);
        System.out.println("--------------------");

        for (int num : nums) {
            count ^= num;
            System.out.println(count);
        }
    }

    public int singleNumber(int[] nums) {
        return 0;
    }
}
