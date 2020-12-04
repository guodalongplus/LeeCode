package com.leecode.DivideAndConquer;


public class treeToDoublyList_offer36 {
    public int val;
    public treeToDoublyList_offer36 left;
    public treeToDoublyList_offer36 right;
    public treeToDoublyList_offer36() {}
    public treeToDoublyList_offer36(int _val) {
        val = _val;
    }

    public treeToDoublyList_offer36(int _val,treeToDoublyList_offer36 _left,treeToDoublyList_offer36 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
    /*创建两个辅助结点，pre是上个结点，head是我们要返回的节点*/
    treeToDoublyList_offer36 pre;
    treeToDoublyList_offer36 head;
    public treeToDoublyList_offer36 treeToDoublyList(treeToDoublyList_offer36 root) {
            if(root==null) return null;
            dfs(root);
            //最后将首尾相连
            head.left=pre;
            pre.right=head;
            return head;
    }
    //中序遍历
    public  void dfs(treeToDoublyList_offer36 cur){
        if(cur==null) return ;
        dfs(cur.left);
        //如果该节点不为头节点，开始建立连接：将上个节点的尾结点指向当前节点cur
        if(pre!=null){
            pre.right=cur;
        }else{
            head=cur;
        }
        //再把当前结点的头节点指向前一个节点
        cur.left=pre;
        //更新上一个节点为当前节点
        pre=cur;

        dfs(cur.right);
    }
}
