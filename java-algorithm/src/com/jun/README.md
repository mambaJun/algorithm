# LeetCode刷题笔记

| 题目序号 | 题目描述 | 解法/思路 | 注意/心得 |
| :------: | :------: | :-------: | :-------: |
| [offer 48](https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/)  | 请从字符串中找出一个**最长的不包含重复字符的子字符串**，计算该最长子字符串的长度. |   双指针/DP| int[] arr = new int[128];<br />利用 ASCII看作一个数组，进行统计 |
| [offer 15二进制中1的个数](https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/) | 输入一个整数，输出该数二进制表示中 1 的个数 | 位运算 | Java中无符号右移K位，取最后一位<br />n >>> k & 1 |
| [347. 前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/) | 给定一个非空的整数数组，返回其中出现频率前 **k** 高的元素 | 堆 | Queue<int[]> queue = new PriorityQueue<int[]>((int[] m, int[] n) -> n[1] - m[1]);
|  | | |  |
|  | | |  |
|          |          |           |           |
|          |          |           |           |



## 涨姿势

1. 利用 ASCII看作一个数组，进行统计

   ```java
   int[] arr = new int[128];
   int[] arr = new int['z' - 'a' + 1];
   ```

2. Java中无符号位移 >>>