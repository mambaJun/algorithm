package com.jun._347前K个高频元素;

import java.util.*;

/**
 * @author Jun
 * @date 2020/9/7 上午9:25
 */
public class _347前K个高频元素 {

    public static void main(String[] args) {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));

    }

    /*
        PriorityQueue 堆，取前 k 个即可
    */
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((int[] m, int[] n) -> n[1] - m[1]);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});

//            if (queue.size() == k) {
//                break;
//            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }

        return res;
    }

}
