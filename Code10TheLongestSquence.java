package com.leecode.Dynamicprogramming;

public class Code10TheLongestSquence {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //存储每个位置时的最长上升序列的长度，先初始化为0
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);//如果nums[i]前存在某个数小于它，和它的最大上升序列对比
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        Code10TheLongestSquence code=new Code10TheLongestSquence();
        int nums[]={2,4,1,6,8,4,29};
        int ans=code.lengthOfLIS(nums);
        System.out.println(ans);
    }



}
