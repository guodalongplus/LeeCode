package com.leecode.DFS;

public class sortedArrayToBST_108 {
    int val;
     sortedArrayToBST_108 left;
     sortedArrayToBST_108 right;
     sortedArrayToBST_108(int x) { val = x; }
    public static sortedArrayToBST_108 sortedArrayToBST(int[] nums) {
        return create(0,nums.length-1,nums);

    }
    public static sortedArrayToBST_108 create(int s,int e,int[]nums){
        if(s>=e){return null;}
        int mid=(e+s)/2;
        sortedArrayToBST_108 node=new sortedArrayToBST_108(nums[mid]);
        node.left=create(s,mid-1,nums);
        node.right=create(mid+1,e,nums);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        sortedArrayToBST_108 node=  sortedArrayToBST(nums);
    }
}
