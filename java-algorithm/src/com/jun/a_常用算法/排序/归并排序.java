package com.jun.a_常用算法.排序;

/**
 * 历届试题 小朋友排队
 * 问题描述
 * 　　n 个小朋友站成一排。现在要把他们按身高从低到高的顺序排列，但是每次只能交换位置相邻的两个小朋友。
 * 　　每个小朋友都有一个不高兴的程度。开始的时候，所有小朋友的不高兴程度都是0。
 * 　　如果某个小朋友第一次被要求交换，则他的不高兴程度增加1，如果第二次要求他交换，
 * 则他的不高兴程度增加2（即不高兴程度为3），依次类推。当要求某个小朋友第k次交换时，他的不高兴程度增加k。
 * 　　请问，要让所有小朋友按从低到高排队，他们的不高兴程度之和最小是多少。
 * 　　如果有两个小朋友身高一样，则他们谁站在谁前面是没有关系的。
 * 输入格式
 * 　　输入的第一行包含一个整数n，表示小朋友的个数。
 * 　　第二行包含 n 个整数 H1 H2 … Hn，分别表示每个小朋友的身高。
 * 输出格式
 * 　　输出一行，包含一个整数，表示小朋友的不高兴程度和的最小值。
 * 样例输入
 * 3
 * 3 2 1
 * 样例输出
 * 9
 * 样例说明
 * 　　首先交换身高为3和2的小朋友，再交换身高为3和1的小朋友，再交换身高为2和1的小朋友，
 * 每个小朋友的不高兴程度都是3，总和为9。
 * 数据规模和约定
 * 　　对于10%的数据， 1<=n<=10；
 * 　　对于30%的数据， 1<=n<=1000；
 * 　　对于50%的数据， 1<=n<=10000；
 * 　　对于100%的数据，1<=n<=100000，0<=Hi<=1000000。
 *
 * @author Jun
 * @date 2020/2/2 下午1:00
 */
public class 归并排序 {

    public static void merge(int[] arr, int s, int m, int e, int[] tmp) {
        int beginIndex = 0;
        int left = s;
        int right = m + 1;

        while (left <= m && right <= e) {
            if (arr[left] < arr[right]) {
                tmp[beginIndex++] = arr[left++];
            } else {
                tmp[beginIndex++] = arr[right++];
            }
        }
        while (left <= m) {
            tmp[beginIndex++] = arr[left++];
        }
        while (right <= e) {
            tmp[beginIndex++] = arr[right++];
        }
        for (int i = 0; i < e - s + 1; i++) {
            arr[s + i] = tmp[i];
        }
    }

    public static void mergeSort(int[] arr, int s, int e, int[] tmp) {
        if (s < e) {
            int mid = s + (s - e) / 2;
            mergeSort(arr, s, mid, tmp);
            mergeSort(arr, mid + 1, e, tmp);
            merge(arr, s, mid, e, tmp);
        }
    }
}
