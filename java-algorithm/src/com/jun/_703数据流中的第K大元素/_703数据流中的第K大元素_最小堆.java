package com.jun._703数据流中的第K大元素;

import java.util.Arrays;

/**
 * @author Jun
 * @date 2021/2/11 下午10:50
 */
public class _703数据流中的第K大元素_最小堆 {
    public static void main(String[] args) {

    }

    class KthLargest {

        private int[] minHeap;
        private int k;
        private int size;

        public KthLargest(int k, int[] nums) {
            if (nums.length >= k) {
                // 1.前k个元素创建小顶堆
                minHeap = buildHeap(nums, k);
                // 2.将剩余元素添加到小顶堆
                for (int i = k; i < nums.length; i++) {
                    add(nums[i]);
                }
            } else {
                minHeap = buildHeap(nums, nums.length);
            }
            size = nums.length;
            this.k = k;

        }

        // 由底至上构造含有k个结点的小顶堆
        private int[] buildHeap(int[] nums, int k) {
            int[] minHeap = Arrays.copyOf(nums, k);
            // 从最后一个非叶子节点开始往前遍历
            for (int i = k / 2 - 1; i >= 0; i--) {
                adjust(minHeap, i);
            }
            return minHeap;
        }

        // 将一个以第i元素为根结点的树调整为小顶堆，默认其子树都小顶堆
        private void adjust(int[] minHeap, int i) {
            int len = minHeap.length;
            // 首先保存根结点值
            int rootVal = minHeap[i];
            // 找到根结点放置的合适位置
            while (2 * i + 1 < len) {
                // 首先左右孩子之间比较大小
                int childIdx = 2 * i + 1;
                if (childIdx + 1 < len && minHeap[childIdx] > minHeap[childIdx + 1]) {
                    childIdx++;
                }
                // 然后比较根结点与孩子
                if (rootVal > minHeap[childIdx]) {
                    minHeap[i] = minHeap[childIdx];
                    i = childIdx;
                } else {
                    break;
                }
            }
            minHeap[i] = rootVal;
        }

        public int add(int val) {
            if (size < k) {
                // 如果堆还没满
                size++;
                // 将元素添加到末尾，然后重新建堆
                int[] temp = Arrays.copyOf(minHeap, size);
                temp[size - 1] = val;
                minHeap = buildHeap(temp, size);
            } else {
                if (val > minHeap[0]) {
                    minHeap[0] = val;
                    adjust(minHeap, 0);
                }
            }
            return minHeap[0];
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}

