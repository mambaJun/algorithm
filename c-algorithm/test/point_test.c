//
// Created by jun on 2020/1/10.
//
#include <stdio.h>
#include <stdlib.h>

#define MAX (10)

int main(void) {
//    int *p_point = (int *) malloc(MAX);
    int arr[MAX] = {0};

    int *p_point = arr;

    for (int i = 0; i < MAX; ++i) {
//        p_point[i] = i;
        *(p_point + i) = i;
        printf("%d %d\n", i, p_point[i]);
//        printf("%d\n", *p_point + i);
    }
    for (int j = 0; j < MAX + MAX + MAX; ++j) {
        printf("%d ", *p_point + j);
    }
    printf("\n-------------------\n");

    unsigned long size = sizeof arr / sizeof *arr;
    printf("size = %lu\n", size);
    printf("%lu\n", sizeof arr);
    printf("%lu\n", sizeof *arr);
    printf("-------------------------------");
    printf("%lu\n", sizeof p_point);
    printf("%lu\n", sizeof *p_point);
    printf("%lu\n", (sizeof p_point / sizeof *p_point));
    putchar('\n');



    return 0;
}
