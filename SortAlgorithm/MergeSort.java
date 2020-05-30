package com.leecode.Sort;

import java.util.Arrays;

public class MergeSort {
//合并函数
    void mergearray(int a[], int first, int mid, int last, int temp[])
    {
        int i = first, j = mid + 1;
        int m = mid,   n = last;
        int k = 0;

        while (i <= m && j <= n)
        {
            if (a[i] <= a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }
        //到这一步骤说明i或者j已到达子序列的末尾，没有加入的数字直接添加到辅助数组后边
        while (i <= m)
            temp[k++] = a[i++];

        while (j <= n)
            temp[k++] = a[j++];

        for (i = 0; i < k; i++)
            a[first + i] = temp[i];
    }
//递归分割
    void mergesort(int a[], int first, int last, int[] temp){
        if(first<last){
            int mid=(first+last)/2;
            mergesort(a,first,mid,temp);//左边已排好顺序
            mergesort(a,mid+1,last,temp);//右边已排好顺序
            mergearray(a,first,mid,last,temp);//合并

        }
    }
    boolean MergeSort(int a[], int n)
    {

        int[] p = new int[n];
        mergesort(a, 0, n - 1, p);
        return true;
    }

    public static void main(String[] args) {
        int[] arr={3,1,4,6,1,2,52,0,1};
        int n=arr.length;
        MergeSort mergeSort=new MergeSort();
        mergeSort.MergeSort(arr,n);
        System.out.println(Arrays.toString(arr));
     }
}
