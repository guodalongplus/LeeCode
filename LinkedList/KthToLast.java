package com.leecode.LinkedList;
/*
* 面试题 02.02. 返回倒数第 k 个节点
实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
*/
public  class KthToLast {

  public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public static int kthToLast(ListNode head, int k) {
      if (head==null) return -1;
      int len=1;
      ListNode node=head;
      while (node!=null){
          node=node.next;
          ++len;
      }

        ListNode temp=head;
      for(int i=0;i<len-k-1;i++){
          temp=temp.next;
      }
        return temp.val ;
    }

    /*
    *  public int kthToLast(ListNode head, int k) {
        ListNode p = head;
        for(int i=0;i<k;i++){
          p = p.next;
        }

        while(p != null){
            p = p.next;
            head = head.next;
        }

        return head.val;
    }
    * */

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        System.out.println(kthToLast(n1,1));
    }
}
