package com.leecode.Dynamicprogramming;

public class MinPathSum {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;

        //初始化第一行和第一列的状态
        for (int i = 1; i < rows; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columns; j++) {
            grid[0][j] = grid[0][j - 1] + grid[0][j];
        }


        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                //走到grid[i][j]是的状态是他的上一列和相邻右侧的一列最小值加上该点的值
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[rows - 1][columns - 1];//最小值为最后一个位置的状态值
    }

    public static void main(String[] args) {
        int [][]nums={
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(minPathSum(nums));
    }
}
