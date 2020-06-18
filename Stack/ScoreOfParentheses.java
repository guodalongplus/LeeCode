package com.leecode.Stack;

import java.util.Stack;
/*856. 括号的分数
给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
() 得 1 分。
AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
(A) 得 2 * A 分，其中 A 是平衡括号字符串。
* */
public class ScoreOfParentheses {
        String str="((()()))";
    public static  int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack();
        stack.push(0); // The score of the current frame

        for (char c: S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {//如果是闭括号的话，弹出栈最后两个元素
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1)); //把不是嵌套括号的值乘2次幂添加到栈里
            }
        }

        return stack.pop();
    }

//    public static int scoreOfParentheses(String S) {
//        int ans = 0, bal = 0;
//        for (int i = 0; i < S.length(); ++i) {
//            if (S.charAt(i) == '(') {
//                bal++;
//            } else {
//                bal--;
//                if (S.charAt(i-1) == '(')//这种情况是有嵌套括号
//                    ans += 1 << bal;
//            }
//        }
//
//        return ans;
//    }


    public static void main(String[] args) {
        String str="((()()))";
        System.out.println(scoreOfParentheses(str));
    }
}
