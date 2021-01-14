
/*
题目：287. 寻找重复数
给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
思路： 
如果没有出现重复的数,比num[i]小的数最多i个，而出现重复的数是自该数字其比他小的数大于i,出现了单调序列，
我们找到从哪里开始递增的，就找到了重复的数据。
用二分法实现，每次统计一个小于目前中心值数据的个数，如果该个数小于中心值说明之前的mid之前的序列正常,重复值在【mid,right】；
而大于mid的话，说明重复值在【left,mid】
时间复杂度：o(nlogn)
*/ 
int findDuplicate(int* nums, int numsSize){
    int ans;
    int l=1;
    int r=numsSize-1;
    int mid;
    while(l<=r){
        mid=(l+r)>>1;
        int count=0;
        for(int i=0;i<numsSize;i++){
            if(nums[i]<=mid){
                count++;
            }
        }
        if(count<=mid){
            l=mid+1;
        }else{
            r=mid-1;
            ans=mid;
        }
    }
    return ans;
}
