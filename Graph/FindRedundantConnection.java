package com.leecode.Graph;

import java.util.Arrays;

public class FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int numV = edges.length; //节点个数
        int[] union = new int[numV+1];//这里我理解为每个点的标识。可以把各节点看作各门派的弟子，标识相同的就是一个门派
        for(int i = 0; i < union.length; i++)
            union[i] = i;
        for(int i = 0; i < edges.length; i++){
            int s = edges[i][0];
            int t = edges[i][1];
            if(union[s] == union[t]){//父节点相同返回
                int[] res = new int[]{s, t};
                return res;
            }
            else{//不同的话,合并两个分量
                int sId = union[s];
                for(int j = 0; j < union.length; j++){
                    if(union[j] == sId)
                        union[j] = union[t];
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[][] arr={{1,2},{2,3},{3,4},{1,4},{1,5}};
        FindRedundantConnection code=new FindRedundantConnection();
        System.out.println(Arrays.toString(code.findRedundantConnection(arr)));
    }

}
