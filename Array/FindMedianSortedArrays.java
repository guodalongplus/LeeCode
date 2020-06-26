package com.leecode.array;

import java.util.Arrays;

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

/*
* 4. 寻找两个正序数组的中位数
给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。

请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。
* */
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m, ansi = -1;
        // median1：前一部分的最大值
        // median2：后一部分的最小值
        int median1 = 0, median2 = 0;

        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2[j]
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                ansi = i;
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            }
            else {
                right = i - 1;
            }
        }

        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;


//2.
//        int m = A.length;
//        int n = B.length;
//        int len = m + n;
//        int left = -1, right = -1;
//        int aStart = 0, bStart = 0;
//        //只遍历到总共长度的一半
//        for (int i = 0; i <= len / 2; i++) {
//            left = right;
//            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
//                right = A[aStart++];//当B中数组没了或者 此时A中元素小于B中元素时把小的值记录
//            } else {
//                right = B[bStart++];//当A中没元素了或者 此时B中元素小于A中元素时把小的值记录
//            }
//        }
//        if ((len & 1) == 0)
//            return (left + right) / 2.0;
//        else
//            return right;

//3.
//        int merge[] = new int[nums1.length + nums2.length];
//        System.arraycopy(nums1, 0, merge, 0, nums1.length);
//        System.arraycopy(nums2, 0, merge, nums1.length, nums2.length);
//        Arrays.sort(merge);
//        int mid = merge.length/2;
//        return merge.length % 2 == 0 ? (double) (merge[mid] +merge[mid-1])/2  :  merge[mid];

    }

    public static void main(String[] args) {
        int num1[]={1,2};
        int num2[]={3,4};
        System.out.println(findMedianSortedArrays(num1,num2));

    }
}