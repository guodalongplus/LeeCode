package com.leecode.Stack;

import java.util.HashMap;
import java.util.Stack;

/*20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
 *
 */
public class BracketsIsValid {
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public BracketsIsValid () {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public  boolean isValid(String s) {

        // 初始化一个栈保存括号
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 当前的括号为右括号
            if (this.mappings.containsKey(c)) {

                // 获取栈顶元素判断该元素是否为空，为空的话用其他符号代替，不为空的话将其弹出保存进行下一步判断
                char topElement = stack.empty() ? '#' : stack.pop();

                // 如果该位上的括号不和此时栈顶括号匹配就返回flase
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                //当前的括号为左括号，将此括号压入栈中等待匹配
                stack.push(c);
            }
        }

        //空串
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String bra="(){}[]";
        BracketsIsValid bracketsIsValid=new BracketsIsValid();
        System.out.println(bracketsIsValid.isValid(bra));
    }
}
