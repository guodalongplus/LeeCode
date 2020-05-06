package com.leecode.Dynamicprogramming;

public class Code11DifferPaths {
    public int uniquePaths(int m, int n) {
        int squre[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            squre[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            squre[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                squre[i][j] = squre[i - 1][j] + squre[i][j - 1];
            }
        }
        return squre[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Code11DifferPaths code=new Code11DifferPaths();
        System.out.println(code.uniquePaths(4,4));
    }
}
