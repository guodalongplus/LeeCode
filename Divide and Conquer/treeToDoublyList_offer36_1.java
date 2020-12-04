package com.leecode.DivideAndConquer;

public class treeToDoublyList_offer36_1 {
    public int val;
    public treeToDoublyList_offer36_1 left;
    public treeToDoublyList_offer36_1 right;
    public treeToDoublyList_offer36_1() {}

    public treeToDoublyList_offer36_1(int _val) {
        val = _val;
    }

    public treeToDoublyList_offer36_1(int _val,treeToDoublyList_offer36_1 _left,treeToDoublyList_offer36_1 _right) {
        val = _val;
        left = _left;
        right = _right;
    }


    public treeToDoublyList_offer36_1 treeToDoublyList(treeToDoublyList_offer36_1 root) {
        if(root == null){
            return root;
        }
        treeToDoublyList_offer36_1[] treeToDoublyList_offer36_1s = new treeToDoublyList_offer36_1[2];
        treeToDoublyList_offer36_1s = treeTo(root);
        //让双向列表变为循环双向列表
        treeToDoublyList_offer36_1s[1].right = treeToDoublyList_offer36_1s[0];
        treeToDoublyList_offer36_1s[0].left = treeToDoublyList_offer36_1s[1];
        return treeToDoublyList_offer36_1s[0];
    }
    public treeToDoublyList_offer36_1[] treeTo(treeToDoublyList_offer36_1 root){
        treeToDoublyList_offer36_1[] treeToDoublyList_offer36_1s1 = new treeToDoublyList_offer36_1[2];//记录左子树的头尾指针
        treeToDoublyList_offer36_1[] treeToDoublyList_offer36_1s2 = new treeToDoublyList_offer36_1[2];//记录右子树的头尾指针
        treeToDoublyList_offer36_1[] treeToDoublyList_offer36_1s3 = new treeToDoublyList_offer36_1[2];//记录该子树的头尾指针
        //判断是否为叶子节点，若是，直接返回
        if(root.left == null && root.right == null){
            treeToDoublyList_offer36_1s1[0] = root;
            treeToDoublyList_offer36_1s1[1] = root;
            return treeToDoublyList_offer36_1s1;
        }
        //判断左子树是否为空，若不为空，遍历寻找左子树的头尾结点
        if(root.left != null){
            treeToDoublyList_offer36_1s1 = treeTo(root.left);
        }else{//如果为空，将头指针设为根节点，方便后面返回结果
            treeToDoublyList_offer36_1s1[0] = root;
        }
        //判断右子树是否为空，若不为空，遍历寻找右子树的头尾结点
        if(root.right != null){
            treeToDoublyList_offer36_1s2 = treeTo(root.right);
        }else{//如果为空，将尾指针设为根节点，方便后面返回结果
            treeToDoublyList_offer36_1s2[1] = root;
        }
        //链接操作:若左子树不为空，将左子树尾结点指针指向根节点,再将根节点左子树指针指向左子树的尾结点
        if(treeToDoublyList_offer36_1s1[0] != root){
            treeToDoublyList_offer36_1s1[1].right = root;
            root.left = treeToDoublyList_offer36_1s1[1];
        }
        //链接操作:若右子树不为空,将右子树头结点指针指向根节点,再将根节点右子树指针指向右子树的头结点
        if(treeToDoublyList_offer36_1s2[1] != root){
            treeToDoublyList_offer36_1s2[0].left = root;
            root.right = treeToDoublyList_offer36_1s2[0];
        }
        //最后返回该树递归过程找到的该树的首尾结点
        treeToDoublyList_offer36_1s3[0] = treeToDoublyList_offer36_1s1[0]; treeToDoublyList_offer36_1s3[1] = treeToDoublyList_offer36_1s2[1];
        return treeToDoublyList_offer36_1s3;
    }
    
}
