package com.leecode.Tree;

/*
* 100. 相同的树
给定两个二叉树，编写一个函数来检验它们是否相同。
如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。*/
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class IsSameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.right, q.right)&&isSameTree(p.left, q.left);
    }


    public static void main(String[] args) {
        TreeNode root1=new TreeNode(1);
        TreeNode root1_2=new TreeNode(2);
        TreeNode root1_3=new TreeNode(3);
        TreeNode root2=new TreeNode(1);
        TreeNode root2_2=new TreeNode(1);
        TreeNode root2_3=new TreeNode(3);
        root1.right=root1_2;
        root1.left=root1_3;
        root2.right=root2_2;
        root2.left=root2_3;
        System.out.println(isSameTree(root1,root2));
    }
}