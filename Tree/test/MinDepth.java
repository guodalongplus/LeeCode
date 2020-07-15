/*
* 111. 二叉树的最小深度
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明: 叶子节点是指没有子节点的节点。
示例:
给定二叉树 [3,9,20,null,null,15,7],*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class MinDepth {
    public static int minDepth(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (root.right == null)
            return minDepth(root.left) + 1;
        if (root.left == null)
            return minDepth(root.right) + 1;
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }



    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        TreeNode n2=new TreeNode(9);
        TreeNode n3=new TreeNode(20);
        TreeNode n4=new TreeNode(1);
        TreeNode n5=new TreeNode(1);
        root.right=n2;
        root.left=n3;
        n3.right=n4;
        n3.left=n5;
        System.out.println(minDepth(root));
    }
}
