package com.leecode.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class code02hasPathSum {
    public List<List<Integer>> pathSum(treeNode root) {
        //res保存所有的成功路径
        List<java.util.List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //Deque接口，Deque的含义是“double ended queue”，即双端队列，它既可以当作栈使用，也可以当作队列使用
        Deque<Integer> path = new ArrayDeque<>();
        pathSum(root, path, res);
        return res;

    }

    public void pathSum(treeNode node,  Deque<Integer> path, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        path.addLast(node.val);
        if (node.left == null && node.right == null) {
            res.add((new ArrayList<>(path)));
            //回到上一个节点
            path.removeLast();
            return;
        }
        //不符合上述情况的话是不到叶子节点，继续向下搜索，进入左枝和右枝，分别建立新的栈，进出栈互不影响。
        // 符合出栈条件的话，把路径保留到res,并退回上各节点（不加入新的权值）
        pathSum(node.left,  path, res);
        pathSum(node.right,  path, res);
        path.removeLast();
    }


    public static void main(String[] args) {
        treeNode root1 = new treeNode(1);
        treeNode node2 = new treeNode(2);
        treeNode node2_2 = new treeNode(2);
        treeNode node3 = new treeNode(3);
        treeNode node4 = new treeNode(4);
        treeNode node5 = new treeNode(5);
        treeNode node5_5 = new treeNode(5);
        treeNode node0 = new treeNode(0);

        root1.left=node2;
        node2.left=node3;
        node2.right=node2_2;
        node3.left=node4;
        root1.right=node5;
        node5.left=node5_5;
        node5.right=node0;
        code02hasPathSum method=new code02hasPathSum();
        //把根节点和目标值传入函数中
        int sum=0;
        List<List<Integer>> res=method.pathSum(root1);
        System.out.println(res);
        for (List list :res){
            for (Object i: list){
                sum=sum+(int)i;
            }
        }
        System.out.println(sum);
    }
}
