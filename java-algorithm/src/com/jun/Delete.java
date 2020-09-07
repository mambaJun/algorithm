package com.jun;

public class Delete {

    public static void main(String[] args) {
        int n = 10;
        int i = 3;
        while (i-- > 0) {
            System.out.printf("%d ", n >> i & 1);
        }
    }
}