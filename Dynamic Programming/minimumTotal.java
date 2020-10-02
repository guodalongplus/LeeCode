package com.leecode.Dynamicprogramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class minimumTotal {
    public static int minimumSum(List<List<Integer>> triangle) {
        int len=triangle.size();
        int[][] dp = new int[len + 1][len + 1];//保存状态值
        for(int i=len-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                //状态变换方程 ：从下往上将上依次更新状态，要么上个状态最小要么是开辟新的状态
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);

            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new LinkedList<>();
        triangle.add(new LinkedList<>(Arrays.asList(2)));
        triangle.add(new LinkedList<>(Arrays.asList(3, 4)));
        triangle.add(new LinkedList<>(Arrays.asList(6, 5, 7)));
        triangle.add(new LinkedList<>(Arrays.asList(4, 1, 8, 3)));
        System.out.println(minimumSum((triangle)));
    }



}
