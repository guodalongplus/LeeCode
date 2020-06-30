package com.leecode.LinkedList;
/*
* 21. 合并两个有序链表
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 */
public class MergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val;}
        ListNode(int val, ListNode next) { this.val = val;this.next = next;}
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        //选定头节点
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null)
//            return l2;
//        if (l2 == null)
//            return l1;
//        ListNode dummy = new ListNode(0);
//        ListNode curr = dummy;
//        while (l1 != null && l2 != null) {
//            //比较一下，哪个小就把哪个放到新的链表中
//            if (l1.val <= l2.val) {
//                curr.next = l1;
//                l1 = l1.next;
//            } else {
//                curr.next = l2;
//                l2 = l2.next;
//            }
//            curr = curr.next;
//        }
//        //然后把那个不为空的链表挂到新的链表中
//        curr.next = l1 == null ? l2 : l1;
//        return dummy.next;
//
//    }
public static void main(String[] args) {
  ListNode n1=new ListNode(1);
  ListNode n2=new ListNode(2);
  ListNode n3=new ListNode(3);
  ListNode n21=new ListNode(1);
  ListNode n22=new ListNode(3);
  ListNode n23=new ListNode(5);
  n1.next=n2;
  n2.next=n3;
  n21.next=n22;
  n22.next=n23;
    ListNode node=mergeTwoLists(n1,n21);
  while (node!=null){
      System.out.println(node.val);
      node=node.next;
  }
}
}
