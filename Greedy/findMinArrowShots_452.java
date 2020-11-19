package com.leecode.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class findMinArrowShots_452 {
    public int findMinArrowShots(int[][] points) {
        int len=points.length;
        if(len<2){
            return len;
        }
        //按区间终点排序
        Arrays.sort(points,new Comparator<int[]>(){
            @Override
            public int compare(int[] point1,int[] point2){
                if(point1[1]!=point2[1]){
                    return  Integer.compare(point1[1], point2[1]);
                }
                return Integer.compare(point1[0], point2[0]);
            }
        });

        int count=1;
        int end=points[0][1];
        for(int i=1;i<len;i++){
            if(points[i][0]>end){
                //起点大于此时上一个终点需要新的箭
                end=points[i][1];//更新终点
                count++;
            }
        }
        return count;
    }
}
