package com.leecode.Graph;

import java.util.*;

public class GardenNoAdj {
    public int[] gardenNoAdj(int N, int[][] paths) {
        /* 这是一道简单题，限制每个节点的度为3，同时提供四种颜色，因此不需要回溯 */
        /* 初始化节点，使用map保存节点与其临界点的关系 */
        /* 第一版本采用了内部类构建，参考评论区的HashMap更简洁 */
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i, new HashSet<>());
        }
        /* 初始化路径信息->获得每个花园与那些花园相连接，保存在map中 */
        for (int[] path: paths) {
            int a = path[0] - 1;
            int b = path[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            boolean[] used = new boolean[5];
            /* 查看当前节点的所有邻接点的色彩 */
            for (int adj: graph.get(i)) {
                used[res[adj]] = true;
            }
            /* 为当前节点染色 */
            for (int j = 1; j <= 4; j++) {
                if (!used[j]) {//剩下的flase位置就是我们要染的颜色
                    res[i] = j;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int N = 3;
        int[][] paths = {
                {1, 2},
                {2, 3},
                {3, 1},
        };
        GardenNoAdj code =new GardenNoAdj();
        int[] res = code.gardenNoAdj(N, paths);
//        for(int i : res){
//            System.out.println(i);}
        System.out.println("res = " + Arrays.toString(res));
    }

}
