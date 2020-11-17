package com.leecode.Greedy;

import java.util.Arrays;

public class findContentChildren_455 {
    public int findContentChildren(int[] g, int[] s) {
        //先对小朋友的胃口由小到大进行排序
        Arrays.sort(g);
        //对饼干的的尺寸由小到大进行排序
        Arrays.sort(s);
        //记录能满足几位小朋友
        int numbers=0;
        //该指针记录饼干尺寸数组下标
        int j=0;
        for(int i=0;i<g.length;i++){
            while(j<s.length){
                //找到满足的时候，numbers计数，指针移动到饼干尺寸数组下个位置
                if(s[j]>=g[i]){
                    numbers++;
                    j++;
                    break;
                }else{
                    j++;//不满足的话指针向后移动
                }
            }
        }
        return numbers;
    }
}
