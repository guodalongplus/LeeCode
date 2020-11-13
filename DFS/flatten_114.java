package com.leecode.DFS;

public class flatten_114 {
    int val;
     flatten_114 left;
     flatten_114 right;
     flatten_114() {}
     flatten_114(int val) { this.val = val; }
     flatten_114(int val, flatten_114 left, flatten_114 right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
    /*
    每遍历到一个节点需要把该节点的右子树放在左子树最右边的节点上，然后把结点的右子树换位左子树，左子树置为null,继续迭代
    */
    public void flatten(flatten_114 root) {
        while(root!=null){
            if(root.left==null){
                root=root.right;
            }else{
                flatten_114 cur=root.left;
                //找到左子树有最右边的结点cur
                while(cur.right!=null){
                    cur=cur.right;
                }
                //把原来结点的右子树指针指向cur的右孩子结点
                cur.right=root.right;
                //把原来结点的右孩子结点的指针指向左孩子结点
                root.right=root.left;
                //左孩子结点置为null
                root.left=null;
                //进行迭代
                root=root.right;
            }

        }

    }
}
