package com.leecode.HashTable;

import java.util.*;

public class intersection_349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet <Integer> map = new HashSet<>();
        List <Integer> res=new LinkedList<>();
        for(int v:nums1){//将其中一个数组元素无重复地放入哈希表中
            if(!map.contains(v)){
                map.add(v);
            }
        }
        for(int k:nums2){//判断哈希表中有这个元素  且 另一个数组中的元素不在交集里时加入交集
            if(map.contains(k) &&!res.contains(k)){
                res.add(k);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
    public static void main(String[] args) {
        int[] nums1={2,2,1,1,5,4};
        int[] nums2={1,1,2};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));

    }
}
