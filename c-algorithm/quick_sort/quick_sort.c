//
// Created by jun on 2020/1/10.
//
#if 1
#include<stdio.h>

void input(int [], int);

void quick_sort(int [], int, int);

void swap(int *, int *);

void output(int [], int);

int main(void) {
    int n = 6;
    int arr[n] = {-1, 0, 1, 2, -1, -4};
    input(arr, n);
    quick_sort(arr, 0, 5);
    output(arr, n);
    return 0;
}

void output(int a[], int n) {
    while (n--) printf("%d ", *a++);
    putchar('\n');
}

void swap(int *var1, int *var2) {
    int tmp = *var1;
    *var1 = *var2;
    *var2 = tmp;
}

void quick_sort(int a[], int s, int e) {
    if (s >= e) return;
    int i = s;
    int j = e;
    int k = a[s];
    while (i != j) {
        while (i < j && a[j] >= k) j--;
        swap(a + i, a + j);
        while (i < j && a[i] <= k) i++;
        swap(a + i, a + j);
    }
    quick_sort(a, s, i - 1);
    quick_sort(a, i + 1, e);
}

void input(int a[], int n) {
    while (n--) scanf("%d", a++);
}

#endif