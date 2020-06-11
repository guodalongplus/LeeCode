package com.leecode.sorttest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
* 56. 合并区间
给出一个区间的集合，请合并所有重叠的区间。*/
public class Merge {
    public static int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0 || intervals == null) return res.toArray(new int[0][]);
        // 对起点进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 如果有重叠，循环判断哪个起点满足条件
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);//有重叠后判断新的右端点
            }
            // 将现在的区间放进res里面
            res.add(new int[]{left, right});
            // 接着判断下一个区间
            i++;
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] arr={{1,3},{2,6},{8,10},{15,18}};
        //输出: [[1,6],[8,10],[15,18]]
        int[][]newarr=merge(arr);
        for(int[] i:newarr){
            System.out.println(Arrays.toString(i));
        }

    }
}
