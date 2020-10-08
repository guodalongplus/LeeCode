package com.leecode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder_ZIP {
    int val;
    levelOrder_ZIP left;
    levelOrder_ZIP right;
    levelOrder_ZIP(int x) { val = x; }

    public static List<List<Integer>> levelOrder(levelOrder_ZIP root) {
        if(root==null){
            return new ArrayList<List<Integer>>();
        }
        //存放结果
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<levelOrder_ZIP> queue=new LinkedList<levelOrder_ZIP>();
        queue.offer(root);
        int maker=0;
        while(!queue.isEmpty()){
            LinkedList<Integer> tmp = new LinkedList<Integer>();

            int size=queue.size();
            for(int i=size-1;i>=0;i--){
                levelOrder_ZIP node=queue.poll();
                if(res.size()%2==0){//根据结果的大小判断奇偶层
                    tmp.addLast(node.val);
                }else{
                    tmp.addFirst(node.val);
                }
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            res.add(tmp);

            }
        return res;
        }


    public static void main(String[] args) {
     levelOrder_ZIP n1=new levelOrder_ZIP(3);
     levelOrder_ZIP n2=new levelOrder_ZIP(9);
     levelOrder_ZIP n3=new levelOrder_ZIP(20);
     levelOrder_ZIP n4=new levelOrder_ZIP(15);
     levelOrder_ZIP n5=new levelOrder_ZIP(7);
     n1.right=n3;
     n1.left=n2;
     n3.left=n4;
     n3.right=n5;

        System.out.println(levelOrder(n1));
    }
}
