package com.leecode.Graph;

import java.util.Arrays;

public class FindRedundantConnection2 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] path = new int[edges.length+1];//path用来记录节点的值
        Arrays.fill(path, -1);
        int path2 = -1;


        for(int i = 0; i < edges.length; i++) {
            if (path[edges[i][1]] != -1) {
                path2 = i;//记录重复记录的节点位置
            } else {
                path[edges[i][1]] = i;
            }
        }

        //边中出现了入度为2的点
        if (path2 != -1) {
            int node = edges[path2][1]; //记录入度为2的点的值
            int firstEdge = path[node];//记录该点第一个入度的值
            int temp = firstEdge;
            while (temp != -1) {
                int index = edges[temp][0];
                temp = path[index];
                if (index == node) {
                    //找到第一条边引发的环
                    return edges[firstEdge];
                }
            }
            return edges[path2];//前一条边无环则直接删除后一条边
        }

        //所有点的入度都为1，必有环，要删除环中最后输入的边
        boolean[] visited = new boolean[edges.length+1];
        Arrays.fill(visited, false);
        int index = 1;
        while (!visited[index]) {
            visited[index] = true;
            int firstEdge = path[index];
            index = edges[firstEdge][0];
        }
        int result = path[index];
        int temp = edges[result][0];
        int edgeNum = 0;
        while (temp != index) {
            edgeNum = path[temp];
            result = Math.max(result, edgeNum);
            temp = edges[edgeNum][0];
        }
        return edges[result];

    }
}
