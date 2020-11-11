package com.leecode.DFS;

public class isValidBST_98 {
    int val;
    isValidBST_98 left;
    isValidBST_98 right;
    isValidBST_98(int x) { val = x; }
    public boolean isValidBST(isValidBST_98 root) {

        return  judge(root,null,null);
    }

    public boolean judge(isValidBST_98 root,Integer low,Integer high) {
        if(root==null) return true;
        int val=root.val;
        //进入左子树，判断该结点的值是否大于根节点的值
        if(low!=null && val<=low){
            return false;
        }
        //进入右子树，判断该结点的值是否小于根节点的值
        if(high!=null && val>=high){
            return false;
        }
        //继续判断左右支
        if(!judge(root.right,val,high)){
            return false;
        }
        if(!judge(root.left,low,val)){
            return false;
        }

        return true;

    }
}
