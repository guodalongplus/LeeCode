package com.leecode.Sort;

import java.util.Arrays;

public class SelectSort {
    public static void selectsort(int []arr,int n){
        for(int i=0;i<n-1;i++){
            int index=i;
            int j;
            //选出无序列中的最小值，并于有序列中的下个值交换位置
            for(j=i+1;j<n;j++){
                if(arr[index]>arr[j]){
                    index=j;
                }
            }
            int tmp=arr[index];
            arr[index]=arr[i];
            arr[i]=tmp;
        }
    }

    public static void main(String[] args) {
        int [] arr = {49,38,65,97,76,13,27,49};
        selectsort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
