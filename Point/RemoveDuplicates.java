package com.leecode.point;

/*
* 26. 删除排序数组中的重复项
给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

 */

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

//    public static int[] removeDuplicates(int[] nums) {
//        int count=1;
//        int j=0;
//        boolean flag=true;
//        for(int i=0;i<nums.length;i++){
//            flag=true;
//            while(j<nums.length&& flag){
//                if(j==0){
//                    flag=false;
//                    j++;
//                }else{
//                if(nums[j-1]==nums[j]){
//                    j++;
//                }else{
//                    nums[i]=nums[j];
//                    count++;
//                    j++;
//                    flag=false;
//                }
//            }
//        }
//      }
//        return count;
//    }
    public static void main(String[] args) {

        int arr[]={0,1,1,1,2,2,2,3};
        System.out.println(removeDuplicates(arr));
    }
}
