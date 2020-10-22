package com.leecode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class setZeroes_73 {
    public static void setZeroes(int[][] matrix) {
        //两个数组分别存放0元素的行和列的下标
        int rows[] = new int[matrix.length];
        int cols[] = new int[matrix[0].length];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                List<Integer> arr = new ArrayList<>();
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        //将其行和列值为零
        for (int k = 0; k < rows.length; k++) {
            if (rows[k] == 1) {
                matrix[k] = new int[matrix[0].length];
            }

        }
        for (int k = 0; k < cols.length; k++) {
            for (int c = 0; c < matrix.length; c++) {
                if (cols[k] == 1) {
                    matrix[c][k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix={{0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}};
        setZeroes(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }
}

