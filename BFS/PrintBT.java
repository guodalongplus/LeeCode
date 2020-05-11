package com.leecode.BFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class PrintBT {
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList(){{ add(root); }};
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();//poll()返回头结点并把头结点删除，若无的话返回null
            ans.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(3);
        TreeNode t2=new TreeNode(9);
        TreeNode t3=new TreeNode(20);
        TreeNode t4=new TreeNode(15);
        TreeNode t5=new TreeNode(7);
        t1.left=t2;
        t1.right=t3;
        t3.right=t5;
        t3.left=t4;

        PrintBT code=new PrintBT();
        int[]a=code.levelOrder(t1);
        for(int i:a){
            System.out.println(i);
        }

    }
}
