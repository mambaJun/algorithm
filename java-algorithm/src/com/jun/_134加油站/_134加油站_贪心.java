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
public class _134加油站_贪心 {
    /*
        算法描述 - 贪心
        total：累计 油桶的油量，可行的话 total 一定 total >= 0,否则一定不会成功转一圈，返回 -1
            总剩余量<0，说明汽油不足以绕一圈，无解，否则一定有解
        start：标记 符合条件的 起始站
        sum：以某个起始站 开始 累计，判断 该 加油站是不是可行，不行的话换下一个
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int start = 0;
        int sum = 0;

        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];

            if (sum < 0) {
                sum = gas[i] - cost[i];
                start = i;
            } else {
                sum += gas[i] - cost[i];
            }
        }

/*
        这两个 方法的区别在于 先计算 sum 还是先 判断 sum < 0
        1、先计算的话，更新 state = i + 1
            sum = 0，因为 state 已经提前更新为 i + 1，所以直接默认 0即可
        2、先判断的话，更新 state = i
            sum = gas[i] - cost[i] 用来作为下一次的 是否可行的判断条件
        小结：
            这两个种方法的思想都是一样的，只不过是细节实现上有小小不同而已


        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];

            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
*/

        return total >= 0 ? start : -1;
    }

    public static void main(String[] args) {
//        int[] gas = {2, 3, 4};
//        int[] cost = {3, 4, 3};

//        int[] gas = {1, 2, 3, 4, 5};
//        int[] cost = {3, 4, 5, 1, 2};

/*        int[] gas = {5, 1, 2, 3, 4};
        int[] cost = {4, 4, 1, 5, 1};*/

        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

/*
    输入:
    []
    []
    输出
    4
    预期结果
    3
*/

        System.out.println(canCompleteCircuit(gas, cost));
    }
}
