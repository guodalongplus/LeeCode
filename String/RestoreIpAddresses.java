package com.leecode.String;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*93. 复原IP地址
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
来源：力扣（LeetCode）
 * */
public class RestoreIpAddresses {
    int n;
    String s;
    LinkedList<String> segments = new LinkedList<String>();
    ArrayList<String> output = new ArrayList<String>();

    public boolean valid(String segment) {
    /*判断值是否合法
        长度<=3  , 值<=255
    */
        int m = segment.length();
        if (m > 3)
            return false;
        return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
    }

    public void update_output(int curr_pos) {
    /*
    符合要求的ip加入结果集
    */
        String segment = s.substring(curr_pos + 1, n);
        if (valid(segment)) {
            segments.add(segment);
            output.add(String.join(".", segments));
            segments.removeLast();
        }
    }

    public void backtrack(int prev_pos, int dots) {
    /*
    prev_pos : 前一个点的位置
    dots : 还有几个可利用位置
    */
        int max_pos = Math.min(n - 1, prev_pos + 4);
        for (int curr_pos = prev_pos + 1; curr_pos < max_pos; curr_pos++) {

            String segment = s.substring(prev_pos + 1, curr_pos + 1);
            if (valid(segment)) {
                segments.add(segment);          // 合法的话加入segments
                if (dots - 1 == 0)              // 此时填满位置了
                    update_output(curr_pos);
                else
                    backtrack(curr_pos, dots - 1);  // 继续往下寻找
                segments.removeLast();  // 每次循环之后需要把最后一个元素删除
            }

        }
    }

    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        this.s = s;
        backtrack(-1, 3);
        return output;
    }

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses=new RestoreIpAddresses();
        String ip="95729";
        System.out.println(restoreIpAddresses.restoreIpAddresses(ip));
    }
}
