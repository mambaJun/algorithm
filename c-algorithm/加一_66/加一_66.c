//
// Created by jun on 2020/2/3.
//
#include <stdio.h>
#include <stdlib.h>

int get_length(int);

int input_arr(int[], int, int);

int output_arr(int[], int);

int *plusOne(int *digits, int digitsSize, int *returnSize);

int main(void) {
    int num;
    scanf("%d", &num);
    int length = get_length(num);
    printf("%d\n",length);

    int arr[length];
    input_arr(arr, length, num);

    plusOne(num)

    output_arr(arr, length);
    return 0;
}

int output_arr(int arr[], int n) {
    while (n--) {
        printf("%d ", *arr++);
    }
    putchar('\n');
}

int *plusOne(int *digits, int digitsSize, int *returnSize){

}

int input_arr(int arr[], int n, int num) {
    int i;
    for (i = n - 1; i >= 0; i++) {
        arr[i] = num % 10;
        num / 10;
    }
}

int get_length(int num) {
    int count = 0;
    while (num != 0) {
        count++;
        num /= 10;
    }
    return count;
}