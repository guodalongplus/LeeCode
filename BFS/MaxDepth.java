package com.leecode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxDepth {

    public int val;
    public List<MaxDepth> children;

    public MaxDepth() {}

    public MaxDepth(int _val) {
        val = _val;
    }

    public MaxDepth(int _val, List<MaxDepth> _children) {
        val = _val;
        children = _children;
    }


    public static  int maxDepth(MaxDepth root) {
        if (root == null) return 0;
        int sum = 0;
        Queue<MaxDepth> queue = new LinkedList<MaxDepth>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            sum++;
            while (size-- > 0) {
                MaxDepth node = queue.remove();
                for (MaxDepth n : node.children) {
                    queue.add(n);
                }
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        MaxDepth one = new MaxDepth(1);
        MaxDepth two = new MaxDepth(2);
        MaxDepth three = new MaxDepth(3);
        MaxDepth four = new MaxDepth(4);
        MaxDepth five = new MaxDepth(5);
        MaxDepth six = new MaxDepth(6);
        List<MaxDepth> second = new ArrayList<>();
        second.add(three);
        second.add(two);
        second.add(four);
        one.children=second;
        List<MaxDepth> third = new ArrayList<>();
        third.add(five);
        third.add(six);
        three.children = third;
        MaxDepth root = new MaxDepth(1, second);
        System.out.println(maxDepth(one));
    }


}
