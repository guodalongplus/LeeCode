package com.leecode.Search;

import static java.lang.Integer.max;

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i-1] >= 0)//在前几项和为整数的前提下把下个数据加进去
                nums[i] += nums[i-1];
            maxSum = max(maxSum, nums[i]);//更新最大值，取目前的值或者前几项值
        }
        return maxSum;
    }



    public static void main(String[] args) {
        int[] nums={-1};
        System.out.println(maxSubArray(nums));
    }
}
