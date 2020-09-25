package com.leecode.Search;

import java.util.*;

public class CombinationSum2 {
    public  List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), k, 1, n);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> list, int k, int start, int n) {
        if (list.size() == k && n == 0) {//当目标值减为0并且该结果数组中长度达到目标长度时将结果添加到结果集中
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= 9; i++) {
            //选择当前值
            list.add(i);
            //递归
            dfs(res, list, k, i + 1, n - i);//目标值减一，从下个数字开始搜索
            //撤销选择
            list.remove(list.size() - 1);//状态重置
        }
    }

    public static void main(String[] args) {
        CombinationSum2 solution=new CombinationSum2();
        System.out.println(solution.combinationSum3(1,1));
    }

}
