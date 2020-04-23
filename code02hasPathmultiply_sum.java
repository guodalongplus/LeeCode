package com.leecode.tree;

public class code02hasPathmultiply_sum {

public  int sumNumbers(treeNode root){
    return helper(root,0);
}

public  int helper(treeNode root,int i){
    //对于空树 结果返回0
    if(root==null) return 0;
    int temp=i*10 +root.val;
    //递归结束条件是遍历到叶子，返回各支路的累和
    if(root.left==null && root.right==null)
            return temp;
    //普通的情况就是继续向下遍历
    return helper(root.left,temp)+helper(root.right,temp);
}

    public static void main(String[] args) {
        treeNode root1 = new treeNode(1);
        treeNode node2 = new treeNode(2);
        treeNode node3 = new treeNode(3);

        root1.left=node2;
        root1.right=node3;
        code02hasPathmultiply_sum method=new code02hasPathmultiply_sum();
       int sum=method.sumNumbers(root1);
        System.out.println(sum);
    }
}
