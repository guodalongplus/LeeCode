package com.leecode.sorttest;

import java.util.*;
/*
* 179. 最大数
给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
示例 1:
输入: [10,2]
输出: 210
* */
public class LargestNumber {
    private  static class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public static String largestNumber(int[] nums) {
        // 把数组转换为String型
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        //说明zuidawei0
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // 拼接数字
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }

    public static void main(String[] args) {
        int []arr={12,45,12,24,7,60};
        System.out.println(largestNumber(arr));
    }
}
