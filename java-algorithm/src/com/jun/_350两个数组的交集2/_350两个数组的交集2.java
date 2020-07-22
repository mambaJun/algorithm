package com.jun._350两个数组的交集2;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 * <p>
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。e
 *
 * @author Jun
 * @date 2020/7/17 下午7:48
 */
public class _350两个数组的交集2 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    /*
        每个值出现的次数，所以映射关系就成了<元素,出现次数>
        hash 表
    */
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = getMap(nums1);
        Map<Integer, Integer> map2 = getMap(nums2);

        int[] result = new int[Math.max(nums1.length, nums2.length)];
        int index = 0;

        for (Integer key : map1.keySet()) {
            if (map2.containsKey(key)) {
                int count = Math.min(map1.get(key), map2.get(key));
                while (count-- >= 0) {
                    result[index++] = key;
                }
            }
        }

        return Arrays.copyOfRange(result, 0, index);
    }

    private static Map<Integer, Integer> getMap(int[] nums1) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 0);
            }
        }
        return map;
    }

}
