package com.leecode.Search;
/*
* 162. 寻找峰值
峰值元素是指其值大于左右相邻值的元素。

给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。

数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞ */
public class FindPeakElement {
    //直接法
//    public int findPeakElement(int[] nums) {
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] > nums[i + 1])
//                return i;
//        }
//        return nums.length - 1;
//    }

//二分法
public static int findPeakElement(int[] nums) {
    return search(nums, 0, nums.length - 1);
}
    public static  int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])//此时说明峰值在mid的左侧
            return search(nums, l, mid);
        return search(nums, mid + 1, r);//此时说明峰值在mid的右侧
    }

    public static void main(String[] args) {
//        int []nums={3,2,5,6};
        int []nums={1,2,1,5};
        System.out.println(findPeakElement(nums));
    }


}
