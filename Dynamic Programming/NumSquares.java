package com.leecode.Dynamicprogramming;

public class NumSquares {
    public static int numSquares(int n) {
        //定义一个数组保存每个状态的值
        int []sqrts=new int[n+1];
        sqrts[0]=0;//特殊的情况

        for(int i=1;i<=n;i++){
            sqrts[i]=i;//首先最坏的情况是i个1
            for(int j=1;i-j*j>=0;j++){
                //动态状态:此时的状态是min(现有节点的值,能够找到平方和表示或者表示i的部分的情况)
                sqrts[i]=Math.min(sqrts[i],sqrts[i-j*j]+1);
            }
        }
        return sqrts[n];

    }

    public static void main(String[] args) {
        System.out.println(numSquares(5));
    }
}

