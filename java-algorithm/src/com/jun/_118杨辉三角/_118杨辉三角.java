package com.jun._118杨辉三角;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Jun
 * @date 2021/2/12 上午10:31
 */
public class _118杨辉三角 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.generate(3);
        System.out.println(lists.toString());
    }
}

class Solution {
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> ret = new ArrayList<List<Integer>>();
//        for (int i = 0; i < numRows; ++i) {
//            List<Integer> row = new ArrayList<Integer>();
//            for (int j = 0; j <= i; ++j) {
//                if (j == 0 || j == i) {
//                    row.add(1);
//                } else {
//                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
//                }
//            }
//            ret.add(row);
//        }
//        return ret;
//    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> currentRow = new ArrayList<>();
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row) {
                    currentRow.add(1);
                } else {
                    List<Integer> preRow = result.get(row - 1);
                    currentRow.add(preRow.get(col - 1) + preRow.get(col));
                }
            }
            result.add(currentRow);
        }
        return result;
    }
}