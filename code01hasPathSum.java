package com.leecode.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//创建二叉树类
class treeNode{
    int val;
    treeNode left;
    treeNode right;

    treeNode(int x){
        val=x;
    }
}
public class code01hasPathSum {
    public List<List<Integer>> pathSum(treeNode root, int sum) {
        //res保存所有的成功路径
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        //Deque接口，Deque的含义是“double ended queue”，即双端队列，它既可以当作栈使用，也可以当作队列使用
        Deque<Integer> path = new ArrayDeque<>();
        pathSum(root, sum, path, res);
        return res;

    }

    public void pathSum(treeNode node, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        //每个节点需要把权值与sum相减，保存权值(路径)添加栈尾
        sum -= node.val;
        path.addLast(node.val);
        if (sum == 0 && node.left == null && node.right == null) {
            res.add((new ArrayList<>(path)));
            //回到上一个节点
            path.removeLast();
            return;
        }
        //不符合上述情况的话是不到叶子节点，继续向下搜索，进入左枝和右枝，分别建立新的栈，进出栈互不影响。
        // 符合出栈条件的话，把路径保留到res,并退回上各节点（不加入新的权值）
        pathSum(node.left, sum, path, res);
        pathSum(node.right, sum, path, res);
        path.removeLast();
    }


    public static void main(String[] args) {
    //将各个节点赋值
        treeNode root5 = new treeNode(5);
        treeNode node4 = new treeNode(4);
        treeNode node11 = new treeNode(11);
        treeNode node7 = new treeNode(7);
        treeNode node2 = new treeNode(2);
        treeNode node8 = new treeNode(8);
        treeNode node13 = new treeNode(13);
        treeNode node_4 = new treeNode(4);
        treeNode node_5 = new treeNode(5);
        treeNode node1 = new treeNode(1);
        root5.left=node4;
        root5.right=node8;
        node4.left=node11;
        node8.right=node_4;
        node8.left=node13;
        node11.left=node7;
        node11.right=node2;
        node_4.left=node_5;
        node_4.right=node1;

        code01hasPathSum method=new code01hasPathSum();
        //把根节点和目标值传入函数中
        List<List<Integer>> res=method.pathSum(root5,22);
        System.out.println(res);

    }
}
