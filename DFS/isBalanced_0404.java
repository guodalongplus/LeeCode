package com.leecode.DFS;

public class isBalanced_0404 {
    int val;
    isBalanced_0404 left;
    isBalanced_0404 right;

    isBalanced_0404(int x) {
        val = x;
    }


    public boolean isBalanced(isBalanced_0404 root) {
        //叶子节点为平衡二叉树
        if (root == null) return true;
        //计算该节点的左右书高度
        int lefthigh = bfs(root.left);
        int righthigh = bfs(root.right);
        //计算高度的绝对值是否大于1，是的话就不是平衡二叉树，结束递归;小于一的话说明此时平衡，继续向下查找
        if (Math.abs(lefthigh - righthigh) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);

    }

    public int bfs(isBalanced_0404 node) {
        //到达叶子节点高度为0,结束递归
        if (node == null) {
            return 0;
        }
        //不是叶子结点的话，取左右子树的最大高度+1(+1是因为需要包含根部节点)
        return Math.max(bfs(node.left), bfs(node.right)) + 1;

    }
}
