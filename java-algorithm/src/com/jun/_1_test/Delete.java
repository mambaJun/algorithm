package com.jun._1_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Delete {
    // 变量的个数
    private int n;
    //输⼊公式结果（T或F）
// input.length = 2^n
    private String input;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public static void main(String[] args) {
        Delete solution = new Delete();
        System.out.print("请输⼊变量个数: ");
        Scanner scanner = new Scanner(System.in);
        solution.setN(scanner.nextInt());
        System.out.print("请输⼊命题公式值A: ");
        Scanner scanner1 = new Scanner(System.in);
        String s = scanner1.nextLine();
        if (s.length() != Math.pow(2.0, solution.n)) {
            throw new IllegalArgumentException("命题公式值的数量应为2^n");
        }
        HashMap<String, Integer>[] hashMaps = solution.drawTable(solution.n, s);
        for (HashMap<String, Integer> hashMap : hashMaps) {
            System.out.println(hashMap);
        }
        String disjunction = solution.disjunction(hashMaps);
        String conjunctive = solution.conjunctive(hashMaps);
        System.out.println("主析取范式为: " + disjunction);
        System.out.println("主合取范式为: " + conjunctive);
    }

    /**
     * 获得主析取范式
     */
    public String disjunction(HashMap<String, Integer>[] source) {
        List<HashMap<String, Integer>> list = new ArrayList<HashMap<String, Integer>>();
        List<String> list2 = new ArrayList<String>();
        for (HashMap<String, Integer> hashMap : source) {
            if (hashMap.get("A") == 1) {
                list.add(hashMap);
            }
        }
        for (HashMap<String, Integer> item : list) {
            List<String> arrayList = new ArrayList<>();
            for (String s : item.keySet()) {
                if (item.get(s) == 1) {
                    arrayList.add(s);
                } else {
                    arrayList.add("┐" + s);
                }
            }
            String join = "( " + String.join(" ^ ", arrayList) + " )";
            list2.add(join);
        }
        String v = String.join(" V ", list2);
        return v;
    }

    /**
     * 获得主合取范式
     */
    public String conjunctive(HashMap<String, Integer>[] source) {
        List<HashMap<String, Integer>> list = new ArrayList<HashMap<String, Integer>>();
        List<String> list2 = new ArrayList<String>();
        for (HashMap<String, Integer> hashMap : source) {
            if (hashMap.get("A") == 0) {
                list.add(hashMap);
            }
        }
        for (HashMap<String, Integer> item : list) {
            List<String> arrayList = new ArrayList<>();
            for (String s : item.keySet()) {
                if (item.get(s) == 1) {
                    arrayList.add(s);
                } else {
                    arrayList.add("┐" + s);
                }
            }
            String join = "( " + String.join(" V ", arrayList) + " )";
            list2.add(join);
        }
        String v = String.join(" ^ ", list2);
        return v;
    }

    /**
     * 制表 并返回邻接表
     *
     * @param n 命题的个数
     * @param s 命题结果
     */
    public HashMap<String, Integer>[] drawTable(int n, String s) {
        header(n);
//数组⼤⼩
        int lineNumber = (int) Math.pow(2, n);
        System.out.println("-----------------");
        HashMap<String, Integer>[] res = new HashMap[lineNumber];
        for (int i = 0; i < res.length; i++) {
            res[i] = new HashMap<String, Integer>();
        }
//初始化
        for (HashMap<String, Integer> re : res) {
            for (int i = 0; i < n; i++) {
                re.put(String.valueOf((char) ('P' + i)), null);
            }
            re.put("A", null);
        }
//真值表⽣成
        for (int i = 0; i < lineNumber; i++) {
            int k = 0;
            for (int j = n - 1; j >= 0; j--) {
                int result = (i / (int) Math.pow(2, j)) % 2;
                res[i].put(String.valueOf((char) ('P' + k)), result);
                k++;
            }
        }
// 遍历命题结果S
        System.out.println("命题结果" + s);
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if ("T".equals(c)) {
                res[i].put("A", 1);
            } else {
                res[i].put("A", 0);
            }
        }
        return res;
    }

    public void header(int n) {
        StringBuilder headerBuilder = new StringBuilder();
        char c = 'P';
        for (int i = 0; i < n; i++) {
            headerBuilder.append((char) (c + i) + " ");
        }
        headerBuilder.append("A");
        System.out.println(headerBuilder.toString());
    }

    public static boolean validate(String s) {
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if (!c.equals("T") || !c.equals("F")) {
                return false;
            }
        }
        return true;
    }
}
