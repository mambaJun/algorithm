package com.jun._1122数组的相对排序;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jun
 * @date 2020/11/14 下午1:59
 */
public class _1122数组的相对排序 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(Arrays.toString(solution.relativeSortArray(arr1, arr2)));
    }
}

/*
arr = [0 for _ in range(1001)]  # 由于题目说 arr1 的范围在 0-1000，所以生成一个 1001 大小的数组用来存放每个数出现的次数。
ans = []  # 储存答案的数组。
for i in range(len(arr1)):  # 遍历 arr1，把整个arr1的数的出现次数储存在 arr 上，arr 的下标对应 arr1 的值，arr 的值对应 arr1 中值出现的次数。
    arr[arr1[i]] += 1  # 如果遇到了这个数，就把和它值一样的下标位置上 +1，表示这个数在这个下标 i 上出现了 1 次。
for i in range(len(arr2)):  # 遍历 arr2，现在开始要输出答案了。
    while arr[arr2[i]] > 0:  # 如果 arr2 的值在 arr 所对应的下标位置出现次数大于 0，那么就说明 arr 中的这个位置存在值。
        ans.append(arr2[i])  # 如果存在值，那就把它加到 ans 中，因为要按 arr2 的顺序排序。
        arr[arr2[i]] -= 1  # 加进去了次数 -1 ，不然就死循环了。
for i in range(len(arr)):  # 如果 arr1 的值不在 arr2 中，那么不能就这么结束了，因为题目说了如果不在，剩下的值按照升序排序。
    while arr[i] > 0:  # 同样也是找到大于 0 的下标，然后一直加到 ans 中，直到次数为 0。
        ans.append(i)
        arr[i] -= 1
return ans  # 返回最终答案。
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[1000 + 1];

        int n1 = arr1.length;
        int n2 = arr2.length;

        int[] ans = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr[arr1[i]]++;
        }

        int idx = 0;
        for (int i = 0; i < n2; i++) {
            while (arr[arr2[i]--] > 0) {
                ans[idx++] = i;
                --arr2[i];
            }
        }

        for (int i = 0; i < n1; i++) {
            while (arr[i] > 0) {
                ans[idx++] = i;
                arr[i]--;
            }
        }
        return ans;
    }
}