package com.leecode.sorttest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumGap {
    public static int maximumGap(int[] nums) {
            if(nums == null || nums.length == 0) return 0 ;
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for(int num : nums) {
                max = Math.max(num, max);
                min = Math.min(num, min);
            }
            int gap = (int)Math.ceil((double)(max - min) / nums.length);
            if(gap == 0) return 0;
            int size = (max - min) / gap + 1;
            int[] bucketMax = new int[size];
            int[] bucketMin = new int[size];
            Arrays.fill(bucketMax, Integer.MIN_VALUE);
            Arrays.fill(bucketMin, Integer.MAX_VALUE);
        System.out.println(Arrays.toString(bucketMax));
        System.out.println(Arrays.toString(bucketMin));
        //实现排序操作
            for(int val : nums) {
                int idx = (val - min) / gap;
                bucketMax[idx] = Math.max(bucketMax[idx], val);
                bucketMin[idx] = Math.min(bucketMin[idx], val);
            }
            System.out.println(Arrays.toString(bucketMax));
            System.out.println(Arrays.toString(bucketMin));
        System.out.println("gap:"+gap);
            for(int i = 0; i < size; i++) {
                if(bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) continue;
                gap = Math.max(gap, bucketMin[i] - min);
                min = bucketMax[i]; // 上一个最大的距离下一个最小的是相邻节点
            }
            return gap;
        }


//        int n=nums.length;
//        if(n<=2){
//            return n<=1?0:nums[1]-nums[0];
//        }
//
//        int newarr[]=new int[2*n-1];
//        int k=0;
//        Arrays.sort(nums);
//        for(int i=0;i<nums.length;i++){
//            if(i==0){
//            newarr[k++]=nums[i+1]-nums[i];
//            continue;
//            }
//            if(i==nums.length-1){
//                break;
//            }
//            newarr[k++]=nums[i]-nums[i-1];
//            newarr[k++]=nums[i+1]-nums[i];
//        }
//        List<Integer> list = new ArrayList<Integer>();
//        for (int i=0; i<newarr.length; i++) {
//            if(!list.contains(newarr[i])) {
//                list.add(newarr[i]);
//            }
//        }
//        int M=list.get(0);
//        for (int a:list){
//            M=Math.max(a,M);
//            }
//
//        return M;
//    }

    public static void main(String[] args) {
        int []nums={3,6,9,1};
//        int []nums={10};
        System.out.println(maximumGap(nums));
    }
}
