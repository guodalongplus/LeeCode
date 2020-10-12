package com.leecode.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanFinish {
    public static  boolean canFinish(int numCourses, int[][] prerequisites) {
        //存放每门课程的先修课程
        List<List<Integer>> edges=new ArrayList<>();
        //记录每个课程的入度
        int[] indegress=new int[numCourses];
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            edges.add(new ArrayList<>());
        }
        //初始话课程的入度，位于第一个位置说明是某个课程的基础课
        for(int[]single :prerequisites){
            indegress[single[0]]++;
            edges.get(single[1]).add(single[0]);
        }
        //如果某个课程的入度为0,加入队列
        for(int i=0;i<numCourses;i++){
            if(indegress[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int pre=queue.poll();//从该课程往下广度优先搜索
            numCourses--;
            for(int cur:edges.get(pre)){
                if(--indegress[cur]==0){//如果该课程入读减一后入读为0，加入队列
                    queue.add(cur);
                }
            }
        }
        System.out.println(numCourses);
        return numCourses==0;
    }

    public static void main(String[] args) {
        int[][] prerequisites={
                {0,1},
                {1,2},
                {2,1}
        };
        System.out.println(canFinish(3,prerequisites));

    }
}
