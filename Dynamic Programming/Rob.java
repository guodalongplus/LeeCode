package com.leecode.Dynamicprogramming;

public class Rob {
    public static int rob(int[] nums) {
        if(nums.length==0 ||nums==null) return 0; //特殊情况：1.数组为空或者为null 返回0;2.只有一个元素的话几位最大值
        if(nums.length==1) return nums[1];


        int [] M=new int[nums.length];//存储在每个元素的时最大的金额
        M[0]=nums[0];
        M[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            //如果选择偷第i间房子的话，第i-1不能偷，最大金额为前i-2间房加该间房子的金额；如果不偷的话，最大金额为前i-1间房的金额
            M[i]=Math.max(M[i-2]+nums[i],M[i-1]);

        }
        return M[nums.length-1];

    }

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(rob(nums));
    }
}
