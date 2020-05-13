package com.leecode.BFS;

import java.util.*;
/*给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。*/
public class ViewRightTree {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();//先获取该层的元素个数
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {  //将当前层的最后一个节点放入结果列表
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(5);
        TreeNode t5=new TreeNode(4);
//        TreeNode t6=new TreeNode(5);
//        TreeNode t7=new TreeNode(9);
        t1.left=t2;
        t1.right=t3;
        t2.right=t4;
        t3.right=t5;
//        t3.left=t6;
//        t4.left=t7;
//        t3.right=t7;
        ViewRightTree code=new ViewRightTree();
        System.out.println(code.rightSideView(t1));

    }

}
