package com.leecode.LinkedList;
/*
* 147. 对链表进行插入排序
对链表进行插入排序*/
public class InsertionSortList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = head;
        ListNode cur = head.next;
        dummy.next = head;
        while (cur != null) {
            if (pre.val <= cur.val) {// 如果有序的话,指针正常往下指
                pre = cur;
                cur = cur.next;
            } else {
                ListNode p = dummy;
                // 找到一个位置使得p < cur < p.next
                while (p.next.val < cur.val) {
                    p = p.next;
                }
                // 将cur插入到p和p.next之间
                // 因为cur被插到前面，需要调整序列，pre的指针需要跳过cur
                pre.next = cur.next;
                cur.next = p.next;
                p.next = cur;
                // 完成插入后，cur回到pre后面
                cur = pre.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(9);
        ListNode n3=new ListNode(0);
        ListNode n4=new ListNode(7);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        ListNode node=insertionSortList(n1);
        while (n1!=null){
            System.out.println(n1.val);
            n1=n1.next;
        }
    }

}
