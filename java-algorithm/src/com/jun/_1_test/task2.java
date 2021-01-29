package com.jun._1_test;

/**
 * @author Jun
 * @date 2020/11/16 下午6:09
 */
public class task2 {

    static int n;
    static int[][] matrix;

    public static void main(String[] args) {
        init();
        print();
        if (reflexive()) {
            printResult("自反性");
        }
        if (symmetric()) {
            printResult("对称性");
        }
        if (transition()) {
            printResult("传递性");
        }
        if (atiReflexive()) {
            printResult("反自反性");
        }
        if (antiSymmetric()) {
            printResult("反对称性");
        }

    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void init() {
        n = (int) (Math.random() * 100 % 3);

        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//                matrix[i][j] = i == j ? 1 : 0;
                matrix[i][j] = zeroOrOne();
            }
        }
    }

    private static int zeroOrOne() {
        return (int) (Math.random() * 123 % 2);
    }

    private static boolean reflexive() {
        return reflexive(1);
    }

    private static boolean reflexive(int val) {
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] != val) {
                return false;
            }
        }

        return true;
    }


    private static boolean symmetric() {
        if (n == 0) return false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && matrix[j][i] != 1) return false;
            }
        }

        return true;
    }

    private static boolean transition() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (matrix[i][j] == 1 && matrix[j][k] == 1 && matrix[i][k] != 1) return false;
                }
            }
        }

        return true;
    }

    private static boolean atiReflexive() {
        if (n == 0) return false;

        return reflexive(0);
    }

    private static boolean antiSymmetric() {
        if (n == 0) return false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && matrix[i][j] == 1 && matrix[j][i] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printResult(String str) {
        System.out.println(str);
    }
}
