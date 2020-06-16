package com.leecode.Stack;

import java.util.Stack;

class MakeQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

    public MakeQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
        size = 0;
    }
    //添加操作
    public void appendTail(int value) {
        //1.将stak1的所有元素转移到stak2里
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        //2.将新加入的元素放在第一个栈的底部,在栈结构中是后进先出，但是我们实现的是队列的功能，就是后进后出
        stack1.push(value);
        //3.添加完在把原来的元素重新入栈
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        size++;
    }
    //删除操作
    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        size--;
        return stack1.pop();//此时删除的就是最早如队列的元素
    }

}
