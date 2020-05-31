package com.leecode.Sort;

import java.util.Arrays;

public class QuickSort {
    public static void  quickSort(int[] arr,int low,int high){
        if(low<high){
            int index=getBaseInt(arr,low,high);
            quickSort(arr,0,index-1);
            quickSort(arr,index+1,high);
        }
    }
    public  static  int getBaseInt(int[] arr,int low,int high){
        //基准数据
        int tmp=arr[low];
        while (low<high){
            //如果从后往前，arr[high]小于基准数的话,high--,因为最后结果是  基准数左边都要小于它，基准数右边都要大于它
            while (low<high && arr[high]>=tmp) high--;
            //出现arr[high]大于基准数时需要将其赋值给low
            arr[low]=arr[high];

            while(low<high && arr[low]<=tmp) low++;
            arr[high]=arr[low];
        }
        arr[low]=tmp;
        return  low;
    }

    public static void main(String[] args) {
//        int[] arr = { 1, 2, 0, -97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22 };
        int[] arr = { 1, 2, 0, -97, 23};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后:");
        System.out.println(Arrays.toString(arr));
    }
}
