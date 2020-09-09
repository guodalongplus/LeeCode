package com.leecode.Search;


public class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) return false;
        int m=matrix.length;
        int n=matrix[0].length;

        int col=n-1;
        int row=0;

        while( col!=-1 && row!=m ){
            if(matrix[row][col]==target) return true;
            if(matrix[row][col]<target){
                row+=1;
            }else{
                col-=1;
            }

        }
        return false;}
}


