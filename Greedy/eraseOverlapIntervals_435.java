package com.leecode.Greedy;

import java.util.Arrays;

public class eraseOverlapIntervals_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        // 对尾部排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1;
        int pre = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            //计数：最大的不连续区间个数
            if (pre <= intervals[i][0]) {
                count++;
                pre = intervals[i][1];//pre更新为该区间的end
            }
        }
        // 区间总个数-最大的不连续区间个数=最小的去除区间个数
        return intervals.length - count;
    }
}
