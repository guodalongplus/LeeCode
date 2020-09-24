package com.leecode.Search;

import java.util.*;

public class CombinationSum1 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     每减去一个元素，目标值变小
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    private void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {

            if(candidates[i-1]==candidates[i]&& i>begin ){//剪枝操作
                continue;
            }
            path.addLast(candidates[i]);
            dfs(candidates, i+1, len, target - candidates[i], path, res);//这里元素不可重复使用，需要从下个元素(i+1)出发进行递归
            // 状态重置
            path.removeLast();
        }
    }

}
