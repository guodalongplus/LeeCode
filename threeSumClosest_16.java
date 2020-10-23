package com.leecode.array;

import java.util.Arrays;

public class threeSumClosest_16 {
    public static int threeSumClosest(int[] nums, int target) {
        //先排序数组便于精确查找
        Arrays.sort(nums);
        int ans=nums[0]+nums[1]+nums[2];//将前三个数之和作为初始值

        for(int i=0;i<nums.length;i++){
            int start=i+1;
            int end=nums.length-1;
            while(start<end){
                int sum=nums[start]+nums[i]+nums[end];
                //判断此时与目标值的绝对值之差小于结果与目标值之差的话，更新结果集
                if(Math.abs(target-sum)<Math.abs(target-ans)){
                    ans=sum;
                }
                //此时值大于目标值的话，需要寻找小一点的元素，尾指针减一
                if(sum>target){
                    end--;
                }
                //此时值小于目标值的话，需要寻找更大一点的元素，首指针加一
                if(sum<target){
                    start++;
                }
                //相等的话直接返回
                if(sum==target){
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums={-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
    }
}
