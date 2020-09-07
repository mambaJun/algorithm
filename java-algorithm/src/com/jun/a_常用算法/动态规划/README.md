# 动态规划小结

##　一维数组类型　求最优问题
>给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 注意你不能在买入股票前卖出股票。
 示例 1:
 输入: [7,1,5,3,6,4]
 输出: 5
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 示例 2:
 输入: [7,6,4,3,1]
 输出: 0
 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。



![](https://pic.leetcode-cn.com/cc4ef55d97cfef6f9215285c7573027c4b265c31101dd54e8555a7021c95c927-file_1555699418271)

```java
 public static int maxProfit(int[] prices) {

     	// 如果没有则返回０
        if (prices.length == 0) return 0;

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            if (minPrice > prices[i]) minPrice = prices[i];
            if (prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;

//            minPrice = minPrice <= prices[i] ? minPrice : prices[i];
//            maxProfit = prices[i] - minPrice > maxProfit ? prices[i] - minPrice : maxProfit;
        }
        return maxProfit;
    }
```









>假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
> 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
>注意：给定 n 是一个正整数。
> 示例 1：
>输入： 2
>输出： 2
>解释： 有两种方法可以爬到楼顶。
>
>1. 1 阶 + 1 阶
>
>2. 2 阶
>
>示例 2：
>输入： 3
>输出： 3
>解释： 有三种方法可以爬到楼顶。
>
>1.  1 阶 + 1 阶 + 1 阶
>2.  1 阶 + 2 阶
>3.  2 阶 + 1 阶



