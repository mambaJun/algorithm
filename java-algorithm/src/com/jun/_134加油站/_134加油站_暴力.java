package com.jun._134加油站;

/**
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明: 
 * <p>
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * 示例 1:
 * <p>
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * <p>
 * 输出: 3
 * <p>
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 * <p>
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * <p>
 * 输出: -1
 * <p>
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gas-station
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/7/5 下午8:44
 */
public class _134加油站_暴力 {
    /*
        算法描述 - 暴力破解
        通过遍历每一个位置作为起始点，在过程中如果发现不可以的话，换下一个。
        同理，从 [0, n-1]
        count 用来统计 第几次 在 起始点，默认为0次，刚进入程序中 count++,默认1次，这里也符合逻辑
        在这个过程中如果不行的话，立即退出，换下一个为起始点
        如果 count == 2，说明已经遍历一圈
            当前站点的净油量：gas[location] - cost[location]
            油箱里的油量：sum += gas[location] - cost[location]
            如果sum < 0 ，说明不能继续进行
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {

        // 遍历 n 个 加油站，每一个尝试作为初始站点
        for (int i = 0; i < gas.length; i++) {
            if (cost[i] > gas[i]) continue;

            // 第几次在 i 原位置
            int count = 0;
            // 遍历位置
            int location = i;
            // 油箱里油量
            int sum = 0;

            // 第一次经过
            while (count < 2) {
                // 在数组中，通过对数组的长度进行 模运算 实现 数组的循环
                location = location % gas.length;

                // 油箱里的油量，若小于0 则不到 下一站
                sum += gas[location] - cost[location];

                if (sum < 0) break;

                if (location++ == i) count++;
            }

            // 第二次,说明已经遍历一圈了
            if (count > 1) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
//        int[] gas = {2, 3, 4};
//        int[] cost = {3, 4, 3};

//        int[] gas = {1, 2, 3, 4, 5};
//        int[] cost = {3, 4, 5, 1, 2};

        int[] gas = {5, 1, 2, 3, 4};
        int[] cost = {4, 4, 1, 5, 1};

        System.out.println(canCompleteCircuit(gas, cost));
    }
}
