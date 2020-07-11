package com.leecode.Queue;

import java.util.Arrays;
/*设计实现双端队列。
你的实现需要支持以下操作：
MyCircularDeque(k)：构造函数,双端队列的大小为k。
insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
isEmpty()：检查双端队列是否为空。
isFull()：检查双端队列是否满了。

* */
public class MyCircularQueueDoubleStart {
    private int capacity;//队列容量
    private  int[] queue;//队列数组
    private int headIndex;//队头元素index
    private int tail;
    public MyCircularQueueDoubleStart(int k) {
        capacity=k+1;
        queue=new int[capacity];
        headIndex=0;
        tail=0;
    }
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
            headIndex = (headIndex - 1 + capacity) % capacity;
            queue[headIndex] = value;
            return true;
        }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        queue[tail]=value;
        tail=(tail+1)%capacity;
        return true;
            }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }
        headIndex=(headIndex+1)%capacity;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }
        tail=(tail-1+capacity)%capacity;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
     if(isEmpty()){
         return  -1;
     }
     return queue[headIndex];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return  queue[(tail-1+capacity)%capacity];


    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return headIndex==tail;
    }

    /** Checks whether the circular deque is full or not. */

    public boolean isFull() {
        return (tail+1)%capacity==headIndex;

    }

    public static void main(String[] args) {
        MyCircularQueueDoubleStart circularQueueDoubleStart=new MyCircularQueueDoubleStart(4);
        System.out.println(circularQueueDoubleStart.insertFront(1));
        System.out.println(circularQueueDoubleStart.insertFront(2));
        System.out.println(circularQueueDoubleStart.insertLast(4));
        System.out.println(circularQueueDoubleStart.insertFront(3));
        System.out.println(Arrays.toString(circularQueueDoubleStart.queue));
        System.out.println(circularQueueDoubleStart.getFront());
        System.out.println(circularQueueDoubleStart.getRear());
        System.out.println(circularQueueDoubleStart.isEmpty());
        System.out.println(circularQueueDoubleStart.isFull());
    }
}
