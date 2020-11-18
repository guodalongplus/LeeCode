package com.leecode.Greedy;

import java.util.ArrayList;
import java.util.List;

public class canJump_55 {
    //    方法一
     public boolean canJump(int[] nums) {
         //特判
         if(nums[0]==0){
             if(nums.length==1) {return true;
             }else{
                     return false;
                 }
         }

         int end=nums.length-1;
         //记录 0的下标
         List<Integer> O_index=new ArrayList<>();
         for(int i=0;i<=end;i++){
             if(nums[i]==0) {
                 O_index.add(i);
                 }
         }
         //如果全程没有0，那么一定可以走到头
         if(O_index.size()==0){
             return true;
         }

 /*接下来判断0元素与他之前元素的距离，这里分两种情况：
     -->如果0元素位于最后一个位置，那么只要num[i]都小于0元素与它之前元素的距离，就走不到头。
     -->如果0元素不位于最后一个位置，那么只要num[i]都小于等于0元素与它之前元素的距离，就走不到头。
  -->其他情况就可以走到头。
 */
         for(int p:O_index){
             //标志的作用是判断是否 “0”前的元素是否都符合上述条件
             boolean flag=false;
             for(int i=0;i<p;i++){
                 if(p==end){
                 if(nums[i]>=p-i){
                     flag=true;
                     break;
                 }
             }else{
                 if(nums[i]>p-i){
                 flag=true;
             }
             }
         }
         //标注位没变说明走不到头
         if(flag==false) return false;
         }
          return true;
     }
    // 方法二（方法一简化版）
//    public boolean canJump(int[] nums) {
//        for(int i=0;i<nums.length-1;i++){
//            if(nums[i]==0){
//                int p=0;
//                for(int j=0;j<i;j++){
//                    if(nums[j]>i-j){
//                        p=1;
//                    }
//                }
//                if(p==0) return false;
//            }
//        }
//        return true;}



    /*方法三
public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

*/
}
