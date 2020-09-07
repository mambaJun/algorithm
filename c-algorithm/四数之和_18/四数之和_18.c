//
// Created by jun on 2020/1/19.
//
#include <stdio.h>
#include <stdlib.h>

int **fourNum(int *num, int numsSize, int target, int *returnSize, int **returnColumnSize);

int compar(const void *a, const void *b);

int main(void) {

    return 0;
}

int **fourNum(int *nums, int numsSize, int target, int *returnSize, int **returnColumnSize) {
    *returnSize = 0;
    if (numsSize == 0) {
        return 0;
    }

    int **ret = (int **) malloc(sizeof(int *) * (numsSize + 1) * 3);
    short left = 0;
    short right = numsSize - 1;
    short begin = 0;
    short end = numsSize - 1;

    int loopTarget = 0;
    int subTarget = 0;

    *returnColumnSize = malloc(sizeof(int *) * (numsSize + 1) * 3);
    qsort(nums, numsSize, sizeof(int), compar);
    ret[*returnSize] = malloc(sizeof(int) * 4);

    while (begin + 2 < end) {
        left = begin + 1;
        right = end;
        loopTarget = target - nums[begin];
        while (left + 1 < right) {
            int i = left + 1;
            int j = right;
            subTarget = loopTarget - nums[left];
            while (i < j) {
                if (nums[i] + nums[j] < subTarget) {
                    i++;
                    continue;
                }
                if (nums[i] + nums[j] > subTarget) {
                    j--;
                    continue;
                }
                ret[*returnSize][0] = nums[begin];
                ret[*returnSize][1] = nums[left];
                ret[*returnSize][2] = nums[i];
                ret[*returnSize][3] = nums[j];
                (*returnColumnSize)[*returnSize] = 4;
                (*returnSize)++;
                ret[*returnSize] = malloc(sizeof(int) * 4);
                while (i < j && nums[i] == nums[++i]) {}
                while (i < j && nums[j] == nums[--j]) {}
            }
            while (nums[left] == nums[++left] && left + 1 < right) {}
        }
        while (nums[begin] == nums[++begin] && begin + 2 == end) {}
    }
    return ret;
}

int compar(const void *a, const void *b) {
    return *(int *) a - *(int *) b;
}