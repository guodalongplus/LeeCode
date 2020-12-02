package com.leecode.DivideAndConquer;

public class longestSubstring_395 {
    public int longestSubstring(String s, int k) {
        //当字符串为空，或者长度为小于出现的次数k 不符合题意
        if(s.length()==0 || k>s.length()) return 0;
        //当k<2时，说明k=0 or 1,最大长度为字符串的长度
        if(k<2) return s.length();
        //一般情况，不断分割字符串：分割的依据是判断该字符出现的次数是否大于等于k，不是的话在此断开（不包含此字符）
        return count(s.toCharArray(),k,0,s.length()-1);
    }
    public static int count(char[] chars,int k,int p1,int p2){
        if(p2-p1+1<k) return 0;//递归结束条件:  所截取的字符串长度小于k时，不成立，返回0
        int[] times=new int[26];//在所截取的字符串重新统计字符出现频率
        for(int i=p1;i<=p2;i++){
            ++times[chars[i]-'a'];
        }
        while(p2-p1+1>=k &&  times[chars[p1]-'a']<k){//头指针：有一种情况不符合需要向后移动一位
            ++p1;
        }
        while(p2-p1+1>=k  && times[chars[p2]-'a']<k){//尾指针：有一种情况不符合需要向前移动一位
            --p2;
        }
        if(p2-p1+1<k) return 0;//再次做判断，个数小于k直接返回0
        for(int i=p1;i<=p2;i++){
            if(times[chars[i]-'a']<k){//判断p1~p2中每一个字符，频率，有一个小于k的话从此断开
                return Math.max(count(chars,k,p1,i-1),count(chars,k,i+1,p2));
            }
        }
        return p2-p1+1;
    }
}
