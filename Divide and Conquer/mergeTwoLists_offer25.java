package com.leecode.DivideAndConquer;

public class mergeTwoLists_offer25 {
    int val;
    mergeTwoLists_offer25 next;
    mergeTwoLists_offer25(int x) {
        val = x;}

        public mergeTwoLists_offer25 mergeTwoLists (mergeTwoLists_offer25 l1, mergeTwoLists_offer25 l2){
            /*分治做法*/
            //特判
            if (l1 == null && l2 == null) {
                return null;
            }
            return merge(l1, l2);

        }
        //分治思想，递归实现
        public mergeTwoLists_offer25 merge (mergeTwoLists_offer25 n1, mergeTwoLists_offer25 n2){
            //递归结束条件 当传入节点中其中有一个为空就返回另一个，不再做比较
            if (n1 == null) {
                return n2;
            }
            if (n2 == null) {
                return n1;
            }
            //创建过程节点
            mergeTwoLists_offer25 head = new mergeTwoLists_offer25(0);

            if (n1.val < n2.val) {
                head = n1;
                head.next = merge(n1.next, n2);//head的下个节点为除去已经赋值的结点的下个节点为头的链表和另一条链表的merge操作
            } else {
                head = n2;
                head.next = merge(n1, n2.next);

            }
            return head;

        }
        /*双指针做法*/
        // mergeTwoLists_offer25 node=new mergeTwoLists_offer25(0), cur=node;
        // while(l1!=null && l2!=null){
        //     if(l1.val<l2.val){
        //         cur.next=l1;
        //         l1=l1.next;
        //     }else{
        //         cur.next=l2;
        //         l2=l2.next;
        //     }
        //     cur=cur.next;
        // }
        // cur.next=l1!=null?l1:l2;
        // return node.next;

    }

