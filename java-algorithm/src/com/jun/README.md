# LeetCode刷题笔记

| 题目序号 | 题目描述 | 解法/思路 | 注意/心得 |
| :------: | :------: | :-------: | :-------: |
| [offer 48](https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/)  | 请从字符串中找出一个**最长的不包含重复字符的子字符串**，计算该最长子字符串的长度. |   双指针/DP| int[] arr = new int[128];<br />利用 ASCII看作一个数组，进行统计 |
| [offer 15二进制中1的个数](https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/) | 输入一个整数，输出该数二进制表示中 1 的个数 | 位运算 | Java中无符号右移K位，取最后一位<br />n >>> k & 1 |
| [347. 前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/) | 给定一个非空的整数数组，返回其中出现频率前 **k** 高的元素 | 堆 | 未完成 |
| [77. 组合](https://leetcode-cn.com/problems/combinations/) | 给定两个整数 *n* 和 *k*，返回 1 ... *n* 中所有可能的 *k* 个数的组合。 | 回溯（方法）+剪枝（优化） | 利用剪枝 减少不必要的样例 |
| [56. 合并区间](https://leetcode-cn.com/problems/merge-intervals/) | 给出一个区间的集合，请合并所有重叠的区间。 | 贪心 | end = Math.max(end, intervals[i][1]); |
| [剑指 Offer 59 - I. 滑动窗口的最大值](https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/) | 一个数组 `nums` 和滑动窗口的大小 `k`，请找出所有滑动窗口里的最大值 | 暴力/ **单调队列** | ***单调队列*** |
| [208. 实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/) | 实现一个 Trie (前缀树)，包含 `insert`, `search`, 和 `startsWith` 这三个操作。 | Trie树 |           |



## 涨姿势

1. 利用 ASCII看作一个数组，进行统计

   ```java
   int[] arr = new int[128];
   int[] arr = new int['z' - 'a' + 1];
   ```

2. Java中无符号位移 >>>

3. 数组模拟 栈

   ```java
   // 栈 生成
   int[] stack = new int[N]; // 栈
   int top = -1;			  // 栈顶
   // 栈 操作
   stack[++top] = x;		  // 入栈
   top--;					  // 出栈
   stack[top]				  // 栈顶
   top >= 0 ? not empty 	  // 判空
       	 : empty
   ```

4. 数组模拟 队列

   ```java
   // 队列 生成
   int[] queue = new int[N];
   int head = 0;
   int tail = -1;
   
   // 队列 操作
   queue[++tail] = x;			// 入队
   head++;						// 出队
   queue[head];				// 队头
   queue[tail];				// 队尾
   head <= tail ? not empty	// 判空 
   			 : empty
   ```

5. Java 中 根据 二维数组的 每个数组项 的第一个元素排序

   ```java
   Arrays.sort(arr, Comparator.comparing(obj -> obj[0]));
   ```

   