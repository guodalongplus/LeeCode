package com.leecode.String;
import java.util.HashMap;
/*
* 115. 不同的子序列
给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）*/
public class NumDistinct {
    int count = 0;
    public int numDistinct(String s, String t) {
        HashMap<String, Integer> map = new HashMap<>();
        numDistinctHelper(s, 0, t, 0, map);//开始位置标志分别指向S 、T的第一个位置
             return count;
    }

    private void numDistinctHelper(String s, int s_start, String t, int t_start,
                                   HashMap<String, Integer> map) {
        if (t_start == t.length()) {
            count++;
            return;
        }
        if (s_start == s.length()) {
            return;
        }
//        String key = s_start + "@" + t_start;//1@1
//        if (map.containsKey(key)) {
//            count += map.get(key);
//            return;
//        }
        int count_pre = count;
        //当前字母相等，s_start 后移一个，t_start 后移一个
        if (s.charAt(s_start) == t.charAt(t_start)) {
            numDistinctHelper(s, s_start + 1, t, t_start + 1, map);
        }
        //出来以后，继续尝试不选择当前字母，s_start 后移一个，t_start 不后移
        numDistinctHelper(s, s_start + 1, t, t_start, map);

        //将增量存起来
//        int count_increment = count - count_pre;
//        map.put(key, count_increment);
    }

    public static void main(String[] args) {
    NumDistinct method=new NumDistinct();
    String s= "babgagaaaggaabagg";
    String t="bag";
    System.out.println(method.numDistinct(s, t));
    }

}


