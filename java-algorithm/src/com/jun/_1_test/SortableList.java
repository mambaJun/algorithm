package com.jun._1_test;

/**
 * @author: Jun
 * @date: 2020/10/22 17:44
 */
public class SortableList {
    private int n;
    private int maxSize;
    private int[] list;
    private int[] aux;

    public static void main(String[] args) {
        SortableList sortableList = new SortableList(10);
        sortableList.output();
        sortableList.quickSort();
        sortableList.mergeSort();
        sortableList.output();
    }


    public SortableList(int size) {
        maxSize = size;
        list = new int[size];
        for (int i = 1; i <= size; i++) {
            list[i - 1] = (int) (i * 1000 * Math.random() / 12);
        }
        aux = new int[size];
        n = 0;
    }

    private void mergeSort() {
        mergeSort(0, list.length - 1);
    }

    private void mergeSort(int left, int right) {
        if (left >= right) return;

        int mid = (left + right) >> 1;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }

    private void merge(int start, int mid, int end) {
        int left = start;
        int right = mid + 1;

        for (int i = start; i <= end; i++) aux[i] = list[i];

        for (int i = start; i <= end; i++) {
            if (left > mid) {
                list[i] = aux[right++];
                continue;
            }
            if (right > end) {
                list[i] = aux[left++];
                continue;
            }

            list[i] = aux[left] < aux[right] ? aux[left++] : aux[right++];
        }
    }

    private void quickSort() {
        quickSort(0, list.length - 1);
    }

    private void quickSort(int left, int right) {
        if (left >= right) return;

        int lo = left;
        int hi = right;
        int num = list[left];

        while (lo != hi) {
            while (lo < hi && list[hi] >= num) hi--;
            if (lo < hi) swap(lo, hi);

            while (lo < hi && list[lo] <= num) lo++;
            if (lo < hi) swap(lo, hi);
        }
        quickSort(left, lo - 1);
        quickSort(lo + 1, right);
    }

    void swap(int i, int j) {
        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }

    private void output() {
        for (int i : list) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}
