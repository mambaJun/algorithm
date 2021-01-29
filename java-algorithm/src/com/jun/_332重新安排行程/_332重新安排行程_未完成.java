package com.jun._332重新安排行程;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 所有的机票必须都用一次 且 只能用一次。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2：
 * <p>
 * 输入：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jun
 * @date 2020/10/11 下午3:24
 */
public class _332重新安排行程_未完成 {
    public static void main(String[] args) {
        String[][] arr = new String[][]{{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};

        List<List<String>> tickets = new ArrayList<>();
        for (String[] strings : arr) {
            List<String> item = new ArrayList<>();
            for (String s : strings) {
                item.add(s);
            }
            tickets.add(item);
        }

        System.out.println(findItinerary(tickets).toString());
    }

    /*
    一个和 欧拉路径 有关的问题，后面想做的时候再来做
     */
    public static List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();

        return res;
    }
}
