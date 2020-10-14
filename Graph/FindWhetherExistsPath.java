package com.leecode.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindWhetherExistsPath {
    public static boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        List<List<Integer>> edges=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        //保存访问标识符 访问为1 未访问为 0
        int[] visit=new int[n];
        visit[start]=1;//先把初始节点置为已访问
        //创造邻接矩，描述节点间的关系
        for(int i=0;i<n;i++){
            edges.add(new ArrayList<>());

        }
        for(int[] cur : graph){
            edges.get(cur[0]).add(cur[1]);
        }
        queue.offer(start);
        while(!queue.isEmpty()){
            int size=queue.size();

            for(int i=0;i<size;i++){
                int p=queue.poll();
                //如果该结点没有出度就跳过
                if(edges.get(p)==null){
                    continue;
                }
                //有的话进行判断
                for(Integer next:edges.get(p)){
                    //如果该点已访问过，就跳过
                    if(visit[next]==1){
                        continue;
                    }
                    //当含有target时该路径存在
                    if(next==target){
                        return true;
                    }
                    //将此点置为已访问，并加入队列中去
                    visit[next]=1;
                    queue.add(next);
                }

            }

        }
        return false;

    }

    public static void main(String[] args) {
        int n = 3;
        int start = 0;
        int target = 2;
        int[][] graph = {
                {0, 1},
                {0, 2},
                {1, 2},
                {1, 2},
        };
        System.out.println(findWhetherExistsPath(3,graph,start,target));
    }
}
