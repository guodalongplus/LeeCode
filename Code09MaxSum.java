package com.leecode.Dynamicprogramming;

import com.leecode.tree.Code07NumbersOfIsland;

public class Code09MaxSum {
    public int maxSubArray(int[] nums) {
        int ans=nums[0];
        int sum=0;
        for(int i :nums){
            if(sum>0){
                sum+=i;
            }else{
                sum=i;
            }
            ans=Math.max(ans,sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums={3,-1,-2,4,1,-4,5};
        Code09MaxSum code=new Code09MaxSum();
        System.out.println(code.maxSubArray(nums));
    }
}
