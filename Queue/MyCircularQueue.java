package com.leecode.Queue;

import java.util.Arrays;

/*
622. 设计循环队列
设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。

你的实现应该支持如下操作：
MyCircularQueue(k): 构造器，设置队列长度为 k 。
Front: 从队首获取元素。如果队列为空，返回 -1 。
Rear: 获取队尾元素。如果队列为空，返回 -1 。
enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
isEmpty(): 检查循环队列是否为空。
isFull(): 检查循环队列是否已满。

 * */
public class MyCircularQueue {
    //定义属性
    private int count;//数组长度
    private int capacity;//队列容量
    private  int[] queue;//队列数组
    private int headIndex;//队头元素index
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.capacity=k;
        this.queue=new int[k];
        this.headIndex=0;
        this.count=0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(this.count==this.capacity){
            return false;
        }else{
            this.queue[(this.headIndex+this.count)%this.capacity]=value; //当前队列不满的话，获取队尾的索引(队列头元素的index+当前长度除以队列总长度再取余数)
            this.count+=1;
            return true;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(this.count==0){
            return false;
        }else{
            this.headIndex=(this.headIndex+1)%this.capacity;//删除队尾元素时，count减小1，所以需要把头元素位置更新为(headIndex+1)%this.capacity
            this.count-=1;
            return true;
        }
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(this.count==0){
            return -1;
        }else{
            return this.queue[this.headIndex];
        }

    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(this.count==0){
            return -1;
        }else{
            return this.queue[(this.headIndex+count-1)%this.capacity];
        }
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
    return (this.count==0);
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (this.capacity==this.count);
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue=new MyCircularQueue(3);
        System.out.println(circularQueue.enQueue(3));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(0));
        System.out.println(circularQueue.Front());
        System.out.println(circularQueue.Rear());
        System.out.println();
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.deQueue());
        System.out.println();
        System.out.println(circularQueue.isEmpty());
        System.out.println(circularQueue.isFull());
        System.out.println(Arrays.toString(circularQueue.queue));
    }
}
