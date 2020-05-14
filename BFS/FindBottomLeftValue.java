package com.leecode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindBottomLeftValue {
    /*返回二叉树最左边结点的值*/
    //BFS
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return -1;
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
                if (i == 0) {  //把该层的第一个节点的值放入
                    res.add(node.val);
                }
            }
        }
        return res.get(res.size() - 1);//返回List中的最后一个值即为最左边的值
    }
//DFS
//    int max_level=1;
//    int left_value;
//    public int findBottomLeftValue(TreeNode root) {
//        dfs(root,1);
//        return left_value;
//    }
//    public void dfs(TreeNode node,int level){
//        if(node==null) return;  //往下没有节点了就返回
//        if(level>=max_level){
//            max_level=level;
//            left_value=node.val;}//否则把最大曾层数赋值为当前的level,并更新left_val
//        dfs(node.right,level+1);//这里有先后顺序，先右的话如果左边不为空就可以覆盖右边
//        dfs(node.left,level+1);
//    }


    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        TreeNode t7=new TreeNode(7);

        t1.left=t2;
        t1.right=t3;
        t2.right=t4;
        t3.right=t6;
        t3.left=t5;
        t5.left=t7;

        FindBottomLeftValue code=new FindBottomLeftValue();
        System.out.println(code.findBottomLeftValue(t1));

    }

}
