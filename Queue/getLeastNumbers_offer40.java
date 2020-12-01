package com.leecode.DivideAndConquer;

import java.util.PriorityQueue;
import java.util.Queue;

public class getLeastNumbers_offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 构造大根堆
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k) { //先填入k个数形成一个暂时的大根堆
                pq.offer(num);
            } else if (num < pq.peek()) {//k个元素后，开始判断新的元素是否大于堆顶，大于的话Pass，小于的话维护新的大顶堆：                                                                                             移除顶元素，加入该元素
                pq.poll();
                pq.offer(num);
            }
        }

        //此时堆中的元素即位最小的k个数
        int[] res = new int[k];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }

}
