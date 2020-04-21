package com.leecode.tree;

public class code00hasPathSum {
    code00hasPathSum left;
    code00hasPathSum right;
    int val;

    code00hasPathSum(int val) {
        this.val = val;
    }


    public static void main(String[] args) {
        code00hasPathSum root = new code00hasPathSum(5);
        code00hasPathSum left1 = new code00hasPathSum(4);
        code00hasPathSum left2 = new code00hasPathSum(11);
        code00hasPathSum left3 = new code00hasPathSum(7);
        code00hasPathSum left4 = new code00hasPathSum(2);
        code00hasPathSum right1 = new code00hasPathSum(8);
        code00hasPathSum right2 = new code00hasPathSum(13);
        code00hasPathSum right3 = new code00hasPathSum(4);
        code00hasPathSum right4 = new code00hasPathSum(1);
        // 构建这棵树
        root.left = left1;
        left1.left = left2;
        left2.left = left3;
        left2.right = left4;
        root.right = right1;
        right1.left = right2;
        right1.right = right3;
        right3.right = right4;
        // 传入根节点
        int sum = 22;
        boolean res = hasPathSum(root, sum);
        if (res) {
            System.out.printf("这棵树有和为%d的路径", sum);
        } else {
            System.out.printf("这棵树没有和为%d的路径", sum);
        }
    }

    // 路径之和方法
    public static boolean hasPathSum(code00hasPathSum root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (root.left == null && root.right == null) {
            return (sum == 0);
        }
        // 开始递归
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }


}
