package com.leecode.Graph;

import java.util.*;

public class FindOrder {
    public static int[] findorder(int numCourses, int[][] prerequisites) {
        //存放每门课程的先修课程
        List<List<Integer>> edges = new ArrayList<>();
        //记录每个课程的入度
        int[] indegress = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int[] result=new int[numCourses];
        int index=0;
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        //初始话课程的入度，位于第一个位置说明是某个课程的基础课
        for (int[] single : prerequisites) {
            indegress[single[0]]++;
            edges.get(single[1]).add(single[0]);
        }
        //如果某个课程的入度为0,加入队列
        for (int i = 0; i < numCourses; i++) {
            if (indegress[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            numCourses--;
            int pre=queue.poll();
            result[index++]=pre;
            for(int cur:edges.get(pre)){
                if(--indegress[cur]==0){
                    queue.add(cur);
                }
            }
        }
        if(numCourses!=0){
            return new int[0];
        }
        return  result;

    }

    public static void main(String[] args) {
        int[][] prerequisites={
                {0,1},
                {1,2}
//                {2,1}
        };
        System.out.println(Arrays.toString(findorder(3,prerequisites)));
    }
}
