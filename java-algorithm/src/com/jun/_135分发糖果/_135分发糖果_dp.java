package com.jun._135分发糖果;

public class _135分发糖果_dp {
    public static int candy(int[] ratings) {
        if (ratings.length < 2)
            return 1;

        int[] dp = new int[ratings.length];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {

            dp[i] = dp[i] == 0 ? 1 : dp[i];

            if (i == dp.length - 1) {

                if (ratings[i - 1] > ratings[i] && dp[i - 1] <= dp[i]) {
                    dp[i - 1] = dp[i] + 1;
                }
                continue;
            }

            if (ratings[i] < ratings[i + 1] && dp[i] >= dp[i + 1]) {
                dp[i + 1] = dp[i] + 1;
            }

            // if (ratings[i] > ratings[i + 1] && dp[i] <= dp[i + 1]) {
            //     dp[i] = dp[i + 1] + 1;
            // }

            if (ratings[i - 1] < ratings[i] && dp[i - 1] >= dp[i]) {
                dp[i] = dp[i - 1] + 1;
            }

            if (ratings[i - 1] > ratings[i] && dp[i - 1] <= dp[i]) {
                dp[i - 1] = dp[i] + 1;
            }
        }

        return sum(dp);
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        /*
         * 输入: [1,3,2,2,1] 输出 3 预期结果 7
         * 
         * 输入: [1,2,87,87,87,2,1] 输出 12 预期结果 13
         */
        int[] ratings = { 1, 2, 87, 87, 87, 2, 1 };
        // int[] ratings = {1, 3, 2, 2, 1};
        // int[] ratings = {1, 0, 2};
        // int[] ratings = {1, 2, 2};

        System.out.println(candy(ratings));
    }
}