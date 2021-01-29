package com.jun._1042不邻接植花;

import java.util.*;

/**
 * 有 N 个花园，按从 1 到 N 标记。在每个花园中，你打算种下四种花之一。
 * <p>
 * paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径。
 * <p>
 * 另外，没有花园有 3 条以上的路径可以进入或者离开。
 * <p>
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 * <p>
 * 以数组形式返回选择的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1, 2, 3, 4 表示。保证存在答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：N = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 示例 2：
 * <p>
 * 输入：N = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 * 示例 3：
 * <p>
 * 输入：N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 10000
 * 0 <= paths.size <= 20000
 * 不存在花园有 4 条或者更多路径可以进入或离开。
 * 保证存在答案。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flower-planting-with-no-adjacent
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/10/5 下午3:50
 */
public class _1042不邻接植花 {

    public static void main(String[] args) {
//        int[][] paths = {{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}};
//        int[][] paths = {{3, 4}, {4, 2}, {3, 2}, {1, 3}};
        int[][] paths = {{1, 2}, {3, 4}, {3, 2}, {4, 2}, {1, 4}};

        System.out.println(Arrays.toString(gardenNoAdj(4, paths)));
    }

    /*
        没有花园有 3 条以上的路径可以进入或者离开。这句话很关键，不用考虑一个节点相邻节点 超过 3个问题
        paths[i] = [x, y] 描述了花园 x 到花园 y 的双向路径：这句话说明了图是个无向图

        这个题目 写出来的时候觉得很简单，但是 在没有写出来前 真的困扰了自己好久，先简单的聊聊 之前的思路
            创建 一个 邻接表 存储图的关系，然后开始 种花 （填充数字），
            关键点在这里：
                填充数字的是 一次性填充 当前 节点 以及 相邻的节点，想法也很简单，觉得 利用一个 boolean[] colors = new boolean[5],来记录 当前相邻已经存在的颜色，因为最多 三条路，所以不会出现第五种 颜色
            出现的问题点：
                比如第一个节点 相邻的节点已经 填充了2 ，但是后面的 填充过程中也后被 2 填充的情况
            目前的处理方法：
                每次处理当前节点，只根据相邻节点 来排除当前节点不符合的情况
    */
    public static int[] gardenNoAdj(int N, int[][] paths) {
        int[] res = new int[N];
        // 构建 邻接表
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        // 存储图关系
        for (int[] path : paths) {
            graph.get(path[0] - 1).add(path[1] - 1);
            graph.get(path[1] - 1).add(path[0] - 1);
        }

        // 从 1-N 对 每个花园进行种花
        for (int i = 0; i < N; i++) {
            boolean[] colors = new boolean[5];
            List<Integer> item = graph.get(i);
            // 获取  当前节点 的相邻节点 种花情况
            for (Integer index : item) colors[res[index]] = true;

            // 种植
            int color = 1;
            while (color <= 4) {
                if (!colors[color]) {
                    res[i] = color;
                    break;
                }
                color++;
            }
        }

        return res;
    }
}
