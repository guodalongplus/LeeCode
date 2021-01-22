/**
25. K 个一组翻转链表
给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。


 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
  
struct ListNode* reverseNode(struct ListNode* head){
    //单结点、空结点不反转
    if(!head || !head->next) return head;
    struct ListNode* pre=NULL;
    struct ListNode* next=NULL;
    struct ListNode* cur=head;
    while(cur){
        next=cur->next;    //保存当前节点的下个结点用于后续的反转
        cur->next=pre;     //将当前结点连接到前个结点
        pre=cur;           //更新前个结点为当前节点
        cur=next;          //移动指向当前节点的指针，继续反转
    }
    return pre;

}

struct ListNode* reverseKGroup(struct ListNode* head, int k){
    if(!head || !head->next) return head;
    struct ListNode *dummy=(struct ListNode*)malloc(sizeof(struct ListNode));
    struct ListNode *pre=dummy;
    struct ListNode *end=dummy;
    dummy->next=head;

    while(end->next){
        for(int i=1;i<=k && end;i++){
            end=end->next;               //找到k步后的尾结点
        }
        if(!end) break;                  //不足k步不反转
        struct ListNode* next=end->next; //保存要反转子链表的尾结点的下个节点用于串联链表  
        end->next=NULL;
        struct ListNode* start=pre->next;
        pre->next=reverseNode(start);    //链接上已反转的部分
        start->next=next;                //头节点反转后变到了尾部，链接上我们保留的即将反转的下个节点
        pre=start;                       //连接部分更新为反转后链表尾部
        end=start;                       //更新反转起始点
    }
    return dummy->next;                  //最后返回呀节点的下个结点
}
