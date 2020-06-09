package com.leecode.sorttest;


import java.util.*;
/*
*1122. 数组的相对排序
给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
* */
public class RelativeSortArray {

    public static  int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] m = new int[20];

        int[] ref = new int[arr1.length];
//把所有数装桶（排序）
        for(int i = 0; i < arr1.length; i++) {
            m[arr1[i]]++;
        }
//        System.out.println("m:"+Arrays.toString(m));

        int cnt = 0;
        for(int i = 0; i < arr2.length; i++) {
            //把arr2中的数放入新的数组中
            while(m[arr2[i]] > 0) {
                ref[cnt++] = arr2[i];
                m[arr2[i]]--;//需要--，因为最后需要arr1多的数值放入新的数组中
            }
        }
//        System.out.println("after m:"+Arrays.toString(m));
        //此时的cnts是不为零元素的最后一个位置
        for(int i = 0; i < 20; i++) {
            while(m[i] > 0) {
                ref[cnt++] = i;
                m[i]--;
                System.out.println(i);
            }
        }
        return ref;
    }



    public static void main(String[] args) {
        int[]arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[]arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray(arr1,arr2)));
//        System.out.println(os);
//        输出：[2,2,2,1,4,3,3,9,6,7,19]

    }
}
