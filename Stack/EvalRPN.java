package com.leecode.Stack;

import java.util.Stack;
/*150. 逆波兰表达式求值
根据 逆波兰表示法，求表达式的值。
有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
说明：
整数除法只保留整数部分。
给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
* */
public class EvalRPN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        Integer op1, op2;
        for (String s : tokens) {
            switch (s) {
                case "+"://遇到一次符号先把栈尾两个元素弹出进行运算操作，再入栈
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 + op2);
                    break;
                case "-":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 - op2);
                    break;
                case "*":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 * op2);
                    break;
                case "/":
                    op2 = numStack.pop();
                    op1 = numStack.pop();
                    numStack.push(op1 / op2);
                    break;
                default://数字的话直接放入栈中
                    numStack.push(Integer.valueOf(s));
                    break;
            }
        }
        //最后一次运算的结果就是最终的结果
        return numStack.pop();
    }

    public static void main(String[] args) {
        String[] str={"5","3","+","15","3","/","*"};
        System.out.println(evalRPN(str));
    }
}
