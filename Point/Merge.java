package com.leecode.point;

import java.util.Arrays;
/*
* 88. 合并两个有序数组
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
说明:
初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。*/
public class Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // 复制一份不包含多于项的nums1
        int [] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // 设置两个指向nums1_copy、nums2的指针
        int p1 = 0;
        int p2 = 0;

        // 为最后的数组设置指针
        int p = 0;

        // 比较设置两个指向nums1_copy和nums2的元素大小，将两者较小的放入num1
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        // 把剩余的元素添进去
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);

    }



    public static void main(String[] args) {
        int[] nums1 = {1, 2, 5, 6, 0, 0, 0, 0};
        int[] nums2 = {3, 4, 5, 7};
        merge(nums1, 4, nums2, 4);
        System.out.println(Arrays.toString(nums1));
    }
}