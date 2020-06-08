package com.leecode.sorttest;

import java.util.Arrays;
/*
* 922. 按奇偶排序数组 II
给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。

对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。

你可以返回任何满足上述条件的数组作为答案。*/
public class SortArrayByParity {
    //对比之下 while要比for循环更加高效，因为用for不但实现遍历还需要做判断，while本身就可以做判断条件
    public static  int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2)
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1)
                    j += 2;
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

        return A;
    }
//    public  static int[] sortArrayByParityII(int[] A) {
//        int k=1;
//        for (int i = 0; i <= A.length - 2; i = i + 2) {
//            if ( A[i] % 2 != 0) {
//                for (int j = k; j <= A.length - 1; j = j + 2) {
//                    if ( A[j] % 2 == 0) {
//                        int tmp = A[i];
//                        A[i] = A[j];
//                        A[j] = tmp;
//                        k=j;
//                        break;
//                    }
//                }
//            }
//        }
//        return A;
//    }

    public static void main(String[] args) {
        int A[]={2,1,3,4};
        System.out.println(Arrays.toString(sortArrayByParityII(A)));
    }
}
