package com.leecode.BFS;

import sun.font.TrueTypeFont;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
* 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
如果小镇的法官真的存在，那么：
1.小镇的法官不相信任何人。
2.每个人（除了小镇法官外）都信任小镇的法官。
3.只有一个人同时满足属性 1 和属性 2 。
* */
public class FIndJudge {
    public int findJudge(int N, int[][] trust) {
    //运用图的思想每个点有出度和入读，所有人都相信法官所以法官出度是0，入度为是N-1
        int[] cnt = new int[N+1];
    //统计出入度
        for (int[] index : trust) {
            cnt[index[0]]--;//出度--
            cnt[index[1]]++;//入度++
        }
        for ( int i = 1; i <= N; i++ ) {
            if ( cnt[i] == N-1 ) return i;
        }
        return -1;

    }

    public static void main(String[] args) {
        FIndJudge code=new FIndJudge();
//        int [][] trust= {{1,3},{2,3},{3,1}};
        int [][] trust={{1,3},{2,3}};
//        int [][] trust={{1,4},{2,4},{3,4}};
        System.out.println(code.findJudge(3,trust));
    }
}
