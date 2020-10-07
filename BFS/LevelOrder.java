package com.leecode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public int val;
    public List<LevelOrder> children;

    public LevelOrder() {}

    public LevelOrder(int _val) {
        val = _val;
    }

    public LevelOrder(int _val, List<LevelOrder> _children) {
        val = _val;
        children = _children;
    }

    @Override
    public String toString() {
        return "LevelOrder{" +
                "val=" + val +
                ", children=" + children +
                '}';
    }

    public static List<List<Integer>> levelOrder(LevelOrder root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        //存放结果
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        //队列存放层序遍历的结点
        Queue<LevelOrder> queue = new LinkedList<LevelOrder>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {//每从队列中取出一个节点，先把值放在临时结合中，将它的孩子们入队
                LevelOrder node = queue.poll();
                tmp.add(node.val);
                if(node.children!=null) {
                    for (LevelOrder n : node.children) {
                        queue.add(n);
                    }
                }
            }
            res.add(tmp);    //返回该层的遍历的值
        }
        return res;
    }
    public static void main(String[] args) {
        LevelOrder one = new LevelOrder(1);
        LevelOrder two = new LevelOrder(2);
        LevelOrder three = new LevelOrder(3);
        LevelOrder four = new LevelOrder(4);
        LevelOrder five = new LevelOrder(5);
        LevelOrder six = new LevelOrder(6);
        List<LevelOrder> second = new ArrayList<>();
        second.add(three);
        second.add(two);
        second.add(four);
        one.children=second;
        List<LevelOrder> third = new ArrayList<>();
        third.add(five);
        third.add(six);
        three.children = third;
        System.out.println(levelOrder(one));
    }
}
