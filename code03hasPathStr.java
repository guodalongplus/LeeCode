package com.leecode.tree;

import java.util.ArrayList;
import java.util.List;

public class code03hasPathStr {
    public List<String> binaryTreePaths(treeNode root) {
        //在外部创建list存储所有路径
        List<String>res = new ArrayList<>();
        helper(root,"",res);
        return res;
    }

    public void helper(treeNode root, String temp, List<String>res){
        if (root!=null){
//            temp += root.val + ""; 这种方法耗费时间
            //将该节点的值并入字符串，再做判断是否可以返回，保证结束时不会多加一个 ->
            temp += Integer.toString(root.val);
            if((root.left==null) && (root.right==null)){
                res.add(temp);}
            else {
                //不是叶子进行箭头链接
                temp+="->";
                helper(root.left, temp, res);//temp进入后，再出来进入右枝
                helper(root.right, temp, res);
            }
        }
    }

    public static void main(String[] args) {
        treeNode root1 = new treeNode(1);
        treeNode node2 = new treeNode(2);
        treeNode node3 = new treeNode(3);
        treeNode node4 = new treeNode(4);

        root1.left=node2;
        root1.right=node3;
        node3.right=node4;
        code03hasPathStr method=new code03hasPathStr();
        List<String> res=method.binaryTreePaths(root1);
        System.out.println(res);
    }
}
