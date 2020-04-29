package com.leecode.tree;

import java.util.ArrayList;
import java.util.List;

public class code06CreateBracktes {
//    public List<String> generateParenthesis(int n) {
//        List<String> ans = new ArrayList();
//        backtrack(ans, new StringBuilder(), 0, 0, n);
//        return ans;
//    }
//
//    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
    //当字符串总长度为2n时结束递归
//        if (cur.length() == max * 2) {
//            ans.add(cur.toString());
//            return;
//        }
//  只要左括号和右括号的个数小于n就可以进行插入新的括号,插入完左括号后，需要删除该括号(回溯),再插入右括号
//        if (open < max) {
//            cur.append('(');
//            backtrack(ans, cur, open+1, close, max);
//            cur.deleteCharAt(cur.length() - 1);
//        }
//        if (close < open) {
//            cur.append(')');
//            backtrack(ans, cur, open, close+1, max);
//            cur.deleteCharAt(cur.length() - 1);
//        }
//    }
public List<String> generateParenthesis(int n) {
    //该方法是用
List<String> res = new ArrayList<>();
    // 特判
        if (n == 0) {
        return res;
    }

    // 执行深度优先遍历，搜索可能的结果
    dfs("", n, n, res);
        return res;
}
    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个可以使用
     * @param right  右括号还有几个可以使用
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 剪枝（如图，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝，注意这个细节）先左后右
        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }


    public static void main(String[] args) {
        code06CreateBracktes create=new code06CreateBracktes();
        List<String>  re=create.generateParenthesis(2);
        System.out.println(re);
    }

}
