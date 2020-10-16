package com.leecode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PossibleBipartition {
    static ArrayList<Integer>[] graph;
    static Map<Integer,Integer> group;
    public  boolean possibleBipartition(int N, int[][] dislikes) {
        graph=new ArrayList[N+1];
        group=new HashMap();


        for(int i=0;i<N+1;i++){
            graph[i]=new ArrayList<Integer>();
        }
        for(int[] cp:dislikes){
            graph[cp[0]].add(cp[1]);
            graph[cp[1]].add(cp[0]);
        }

        for(int node=1;node!=N+1;node++){
            if(!group.containsKey(node)){
                boolean ok=dfs(node,0);
                if(!ok){
                    return false;
                }else{
                    continue;
                }
            }
        }
        return true;

    }

   static boolean dfs(int node,int c){
        //若已经分组，判断是否分组正确
        if(group.containsKey(node)){
            boolean ok=group.get(node)==c;
            return ok;
        }
        //未分组的话，进行分组
        group.put(node,c);
        //再对该人的不喜欢的人分到另一个组
        for(int unlike:graph[node]){
            boolean ok=dfs(unlike,c^1);
            if(!ok) return false;  //发生错误分组的情况是出现了重复分组
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 4;
        int[][] dislikes = {
                {1, 2},
                {1, 3},
                {2, 4},
        };
        PossibleBipartition method=new PossibleBipartition();
        boolean res = method.possibleBipartition(N, dislikes);
        System.out.println("res = " + res);
    }
}
