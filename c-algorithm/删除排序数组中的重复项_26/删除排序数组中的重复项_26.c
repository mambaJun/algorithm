//
// Created by jun on 2020/1/26.
//

/* 参考思想一
其后元素向数组首端移动。注意，CompactIntegers函数需要接受数组及其元素个数作为参数，
函数返回值应为删除操作执行后数组的新元素个数。输出删除后数组中元素的个数并依次输出数组元素。
样例输入: （输入格式说明：5为输入数据的个数，3 4 0 0 2 是以空格隔开的5个整数）
5
3 4 0 0 2
样例输出:（输出格式说明：3为非零数据的个数，3 4 2 是以空格隔开的3个非零整数）
3
3 4 2
样例输入:
7
0 0 7 0 0 9 0
样例输出:
2
7 9
样例输入:
3
0 0 0
样例输出:
0*/

#include <stdio.h>
#include <stdlib.h>

void input(int [], int);

void output(int [], int);

int removeDuplicates(int *nums, int numsSize);

int main(void) {
    int n;
    printf("input number :\n");
    scanf("%d", &n);
    int nums[n];
    input(nums, n);
    int new_length = removeDuplicates(nums, n);
    output(nums, new_length);
    output(nums, n);
    return 0;
}

void output(int nums[], int n) {
    while (n--) {
        printf("%d ", *nums++);
    }
    putchar('\n');
}

int removeDuplicates(int *nums, int numsSize) {
    if (numsSize == 0) {
        return 0;
    }

    int new_index = 0;
    nums[new_index] = nums[0];
    int i;
    for (i = 0; i < numsSize; i++) {
        if (nums[new_index] != nums[i]) {
            nums[++new_index] = nums[i];
        }
    }
    return new_index + 1;
}

void input(int nums[], int n) {
    while (n--) {
        scanf("%d", nums++);
    }
}