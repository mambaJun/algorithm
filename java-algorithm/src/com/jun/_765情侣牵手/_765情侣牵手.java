package com.jun._765情侣牵手;

/**
 * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
 * <p>
 * 人和座位用0到2N-1的整数表示，情侣们按顺序编号，第一对是(0, 1)，第二对是(2, 3)，以此类推，最后一对是(2N-2, 2N-1)。
 * <p>
 * 这些情侣的初始座位row[i]是由最初始坐在第 i 个座位上的人决定的。
 * <p>
 * 示例 1:
 * <p>
 * 输入: row = [0, 2, 1, 3]
 * 输出: 1
 * 解释: 我们只需要交换row[1]和row[2]的位置即可。
 * 示例 2:
 * <p>
 * 输入: row = [3, 2, 0, 1]
 * 输出: 0
 * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
 * 说明:
 * <p>
 * len(row) 是偶数且数值在[4, 60]范围内。
 * 可以保证row 是序列0...len(row)-1的一个全排列。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/couples-holding-hands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2021/2/14 下午11:26
 */
public class _765情侣牵手 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] row = {0, 2, 1, 3};
        System.out.println(solution.minSwapsCouples(row));
    }
}

class Solution {
    /*
        row 原来顺序
        map 顺序的每个值对应的 下标索引，以便后面可以用 O(1) 的速度获取

        row [0, 2, 1, 3]
        map [0, 1, 2, 3]

        算法思路：
            1. 从 0 开始遍历，步长为 2
            2. 在步长这个里面，以第一对 [0, 1] 为例子。里面一定是一对奇偶数，而且偶数正好是比奇数小一（偶数 + 1 = 奇数）
                1. 若有一个是奇数，直接找到 奇数-1 的偶数交换，同时将map的记录信息也交换
                2. 若无奇数，两个都交换
    */
    public int minSwapsCouples(int[] row) {
        int len = row.length;
        // map 记录每个值 对应 的下标索引
        int[] map = new int[len];

        for (int i = 0; i < len; i++) {
            map[row[i]] = i;
        }

        int count = 0;

        for (int odd = 0, even = 1; odd < len; odd += 2, even += 2) {
            if (row[odd] % 2 == 0) {
                count = getCount(row, map, count, even, odd);
            } else if (row[even] % 2 == 0) {
                count = getCount(row, map, count, odd, even);
            } else {

            }
        }

        for (int i = 0, k = 1; k < len; i += 2, k += 2) {
            if (row[i] % 2 == 0) { // 前面是奇数
                count = getCount(row, map, count, k, i);
            } else if (row[k] % 2 == 0) { // 后面是偶数
                count = getCount(row, map, count, i, k);
            } else {
                int index = map[row[i] - 1];
                int tmp = row[k];

                row[k] = row[index];
                row[index] = tmp;

                map[row[k]] = k;
                map[tmp] = index;
                count++;
            }
        }

        return count;
    }

    int getCount(int[] row, int[] map, int count, int oddIndex, int evenIndex) {
        // 判断是否 满足 偶数 + 1 = 奇数
        if (row[oddIndex] != row[evenIndex] + 1) {
            int index = map[row[evenIndex] + 1];
            // 值交换
            int val = row[oddIndex];
            row[oddIndex] = row[index];
            row[index] = val;

            // 索引交换
            map[row[oddIndex]] = oddIndex;
            map[val] = index;
            count++;
        }
        return count;
    }
}
