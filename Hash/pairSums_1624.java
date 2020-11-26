package com.leecode.HashTable;

import java.awt.image.ImageProducer;
import java.util.*;

public class pairSums_1624 {
    public static List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res=new LinkedList<>();
        Map<Integer,Integer> hash=new HashMap<Integer,Integer>();
        for(int v:nums){
            Integer count=hash.get(target-v);
            if(count!=null){//元素出现的次数不为空时
                res.add(Arrays.asList(v,target-v));
                if(count==1){//此时判断如果元素只有一个，加入完需要移除hashmap
                    hash.remove(target-v);
                }else{
                    hash.put(target=v,--count);//有多个的话更新该元素的个数：减一
                }
            }else{
                hash.put(v,hash.getOrDefault(v,0)+1);//统计元素个数
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[]nums = {1, 2, 0, 0, 2, 1, 0, 2, 2, 3 ,2};
        System.out.println(pairSums(nums,2));
    }
}
