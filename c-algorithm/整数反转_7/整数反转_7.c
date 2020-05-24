//
// Created by jun on 2020/1/21.
//
#include <stdio.h>
#include <stdlib.h>

int x_n(int);

int main(void) {
    int max = 0x7fffffff;
    int min = 0x80000000;//int的最大值最小值
    int min = -x_n(31);
    int max = x_n(31) - 1;
    printf("%d %d\n", min, max);
    printf("%x %x\n", min, max);
    printf("%o %o\n", min, max);
    return 0;
}

int x_n(int n) {
    int result = 1;
    while (n--) {
        result *= 2;
    }
    return result;
}