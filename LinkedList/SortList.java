package com.leecode.LinkedList;
/*
* 148. 排序链表
在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。*/
public class SortList {

    public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
    public static ListNode sortList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode midNext = slow.next;
        slow.next = null;
        return merge(sortList(head),sortList(midNext));
    }
    private static ListNode merge(ListNode head1,ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(head1!=null && head2!=null){
            if(head1.val <= head2.val){
                cur.next=head1;
                head1=head1.next;
            }else{
                cur.next=head2;
                head2=head2.next;
            }
            cur=cur.next;
        }
        if(head1!=null){
            cur.next=head1;
        }else if(head2!=null){
            cur.next=head2;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(-1);
        ListNode l3=new ListNode(0);
        ListNode l4=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        ListNode n=sortList(l1);
        while (n!=null){
        System.out.println(n.val);
            n=n.next;
        }
    }
}
