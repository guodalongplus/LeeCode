package com.leecode.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*返回右值所有右值的点的值（层层输出）*/
public class RightTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> re=new LinkedList<>();
        if (root==null) return re;
        re.add(root.val);
        if(root.right==null) return re;
        Queue<TreeNode> q = new LinkedList<>();
        re.add(root.right.val);
        q.add(root.right.left);
        q.add(root.right.right);
        while (!q.isEmpty()){
            TreeNode t1=q.poll();
            TreeNode t2=q.poll();
            if(t1!=null) {
                re.add(t1.val);
                q.add(t1.left);
                q.add(t1.right);}
            if(t2!=null) {
                re.add(t2.val);
                q.add(t2.left);
                q.add(t2.right);
            }
        }
        return re;
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(5);
        TreeNode t5=new TreeNode(4);
        TreeNode t6=new TreeNode(5);
//        TreeNode t7=new TreeNode(3);
        t1.left=t2;
        t1.right=t3;
        t2.right=t4;
        t3.right=t5;
        t3.left=t6;
//        t3.right=t7;
        RightTree code=new RightTree();
        System.out.println(code.rightSideView(t1));

    }
}
