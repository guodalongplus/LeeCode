package com.leecode.Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
* 145. 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。*/
class treeNode{
    int val;
    treeNode left;
    treeNode right;

    treeNode(int x){
        val=x;
    }
}
public class PostorderTraversal {
    List<Integer> res = new ArrayList<>();

    public static  List<Integer> postorderTraversal(treeNode root) {
        LinkedList<treeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            treeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        //输入: [1,null,2,3]
        //   1
        //    \
        //     2
        //    /
        //   3
        //
        //输出: [3,2,1]
        treeNode root= new treeNode(1);
        treeNode right2= new treeNode(2);
        treeNode left3= new treeNode(3);
        root.right=right2;
        right2.left=left3;
        System.out.println(postorderTraversal(root));
    }
}
