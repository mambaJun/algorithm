//
// Created by jun on 2020/1/10.
//
/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
#include <stdio.h>
#include <stdlib.h>

int **threeSum(int *, int, int *, int **);

void quick_sort(int *nums, int start, int end);

void swap(int *p_var1, int *p_var2);

void output(int **p_nums, int *pInt, int **pInt1);

int main(void) {
    int nums[] = {-1, 0, 1, 2, -1, -4};
    int numsSize = sizeof nums / sizeof *nums;
    int *returnSize = NULL;
    int **returnColumnSize = NULL;
    int **result = threeSum(nums, numsSize, returnSize, returnColumnSize);
    output(result, returnSize, returnColumnSize);
    return 0;
}

void output(int **p_nums, int *pInt, int **pInt1) {
    for (int i = 0; i < *pInt; ++i) {
        for (int j = 0; j < 3; ++j) {
            printf("%d ", p_nums[i][j]);
        }
        putchar('\n');
    }
}

int **threeSum(int *nums, int numsSize, int *returnSize, int **returnColumnSize) {
    // 这里的内存分配最大值为c n 3,即排列组合知识
    int **result = (int **) malloc(sizeof(int *) * (numsSize * (numsSize - 1) * (numsSize - 2)) / 6);
    if (numsSize < 3) {
        *returnSize = 0;
        return result;
    }
    int target = 0;
    int index = 0;
    quick_sort(nums, 0, numsSize - 1);
    for (int i = 0; i < numsSize - 2; ++i) {
        if (nums[i] > 0) break;
        if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
            int l = i + 1;
            int r = numsSize - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == target) {
                    result[index] = (int *) malloc(sizeof(int) * 3);
                    result[index][0] = nums[i];
                    result[index][1] = nums[l];
                    result[index][2] = nums[r];
                    index++;
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                    continue;
                } else if (nums[i] + nums[l] + nums[r] < target) {
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                    continue;
                } else {
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                    continue;
                }
            }
        }
    }
    output(result, &index, returnColumnSize);
    printf("-----------------------\n");
    return result;
}

void quick_sort(int a[], int s, int e) {
    if (s >= e) return;
    int k = a[s];
    int i = s, j = e;
    while (i != j) {
        while (i < j && a[j] >= k) j--;
        swap(a + i, a + j);
        while (i < j && a[i] <= k) i++;
        swap(a + i, a + j);
    }
    quick_sort(a, s, i - 1);
    quick_sort(a, i + 1, e);
}

void swap(int *p_s1, int *p_s2) {
    int tmp = *p_s1;
    *p_s1 = *p_s2;
    *p_s2 = tmp;
}