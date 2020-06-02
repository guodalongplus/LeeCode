package com.leecode.test;


import java.util.Arrays;
import java.util.HashMap;

public class Intersect {
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                nums1[k++] = nums1[i++];
                ++j;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main(String[] args) {
        int[] num1={3,2,1,5,7};
        int[] num2={2,6,7,0,1};
        System.out.println(Arrays.toString(intersect(num1,num2)));
        System.out.println(Arrays.toString(num1));
    }
}
