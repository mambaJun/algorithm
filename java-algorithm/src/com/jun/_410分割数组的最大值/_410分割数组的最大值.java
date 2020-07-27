package com.jun._410分割数组的最大值;

/**
 * @author Jun
 * @date 2020/7/25 下午8:19
 */
public class _410分割数组的最大值 {



    public static void main(String[] args) {
//        int[] nums = {7, 2, 5, 10, 8};
        int[] nums = {1, 2, 3, 4, 5};
        int m = 2;
        System.out.println(splitArray(nums, m));
    }

    /*
    本题跟1014 875 非常类似。
    拿到这个题目在纸上画了画，发现用的 暴力，发现代码实现太难，其他的方法想不到，看了参照答案，下面来介绍这个方法
    二分查找
        当 m = 1  result 最大 min
        当 m = m  result 最小 max
        结果一定在 [min, max]中，下面采用二分法 找最优解
        int[] nums = {1, 2, 3, 4, 5};
        int m = 2;
        那这个样例为例子
        min 5   5   8   9
        max 15  10  10  9
        mid 10  7   9   9
        res 10  ^   9   9

     一个相同的例子：
     	给定 n 本书, 第 i 本书的页数为 pages[i].
	    现在有 k 个人来复印这些书籍, 而每个人只能复印编号连续的一段的书
		比如一个人可以复印 pages[0], pages[1], pages[2], 但是不可以只复印 pages[0], pages[2], pages[3] 而不复印 pages[1].

		所有人复印的速度是一样的, 复印一页需要花费一分钟, 并且所有人同时开始复印.
		怎样分配这 k 个人的任务, 使得这 n 本书能够被尽快复印完?

		返回完成复印任务最少需要的分钟数.

     */

    /*
   二分法
   nums = [7,2,5,10,8]
   m = 1，那么整个数组作为一部分，最小的最大值为 32
   m = n，那么每个元素作为一个子数组，从所有元素选取最大值，最小的最大值小为 10

   m 的取值范围为 1 <= m <= n，因此，最大值的最小值的范围为 [10, 32]

   我们利用二分法查找，找出符合 m 的最大值的最小的结果
   二分过程：
   left = 10;
   right = 32
   mid = (left + right) >>> 1 = 21（这个 21 就是一个子数组的最大容量）
   我们假设刚开辟的用来存储的子数组个数 cnt = 1
   那么根据贪心思想，我们将数组元素按顺序逐个往里放
   因此就有如下过程：
   7 < 21
   7 + 2 < 21
   7 + 2 + 5 < 21
   7 + 2 + 5 + 10 > 21
    至此，我们可以看出一个 21 容量的子数组是无法容纳整个数组元素的，因此我们需要开辟第二个子数组来存储剩下的数组元素
   cnt = cnt + 1 = 2
   10 < 21
   10 + 8 < 21
   我们发现，两个子数组可以将整个数组元素放入，而 cnt 刚好等于 m，因此 [7,2,5] 和 [10,8] 就是分割出来的两个子数组，最小的最大值为 18

   为什么是放入元素直到放不下为止？因为要求的是连续子数组，我们需要保证每个连续的子数组的元素和都尽可能的接近 21

   如果我们最终得到的 cnt > m，那么表示我们划分出太多的子数组，也就是意味着一个子数组的容量太少，我们需要再扩大容量，即 left = mid + 1，然后继续进行二分
   如果我们最终得到的 cnt < m，那么表示我们划分出太少的子数组，也就是意味着一个子数组的容量太大，需要减少容量，即 right = mid - 1
   */
    public static int splitArray(int[] nums, int m) {
        // m = 1 结果
        long max = getMax(nums);
        // m = n 结果
        long min = getMin(nums);

        while (min < max) {
            int count = 1;
            long mid = (min + max) / 2;
            int sum = 0;
            for (int num : nums) {
                if (sum + num > mid) {
                    sum = 0;
                    count++;
                }
                sum += num;
            }
            if (count > m) {
                min = mid + 1;
            } else {
                // 这里不太明白 为啥 不是 mid - 1
                max = mid;
            }
        }

        return (int) min;
    }

    private static int getMin(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result = num > result ? num : result;
        }

        return result;
    }

    private static int getMax(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

}
