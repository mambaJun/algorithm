package com.jun._322零钱兑换;

import java.util.Arrays;

/**
 * @author Jun
 * @date 2020/11/11 下午8:58
 */
public class _322零钱兑换 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        System.out.println(solution.coinChange(coins, amount));
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n;
        if (amount == 0) return 0;
        if ((n = coins.length) == 0) return -1;

        Arrays.sort(coins);

        int res = 0;

        for (int i = n - 1; i >= 0; i--) {
            int coin = coins[i];
            res += amount / coin;
            amount %= coin;
        }

        return amount == 0 ? res : -1;
    }
}