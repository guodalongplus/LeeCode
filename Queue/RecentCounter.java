package com.leecode.Queue;

import java.util.LinkedList;
import java.util.Queue;
/*
* 933. 最近的请求次数
写一个 RecentCounter 类来计算最近的请求。
它只有一个方法：ping(int t)，其中 t 代表以毫秒为单位的某个时间。
返回从 3000 毫秒前到现在的 ping 数。
任何处于 [t - 3000, t] 时间范围之内的 ping 都将会被计算在内，包括当前（指 t 时刻）的 ping。
保证每次对 ping 的调用都使用比之前更大的 t 值。
* */
public class RecentCounter {
    Queue<Integer> q;
    public RecentCounter() {
        q = new LinkedList();
    }

    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000)
            q.poll();
        return q.size();
    }

    public static void main(String[] args) {
        RecentCounter counter=new RecentCounter();
        System.out.println(counter.ping(0));
        System.out.println(counter.ping(3000));
        System.out.println(counter.ping(3001));
        System.out.println();
        System.out.println(counter.ping(3002));
        for(int i : counter.q){
            System.out.println(i);
        }
    }
}
