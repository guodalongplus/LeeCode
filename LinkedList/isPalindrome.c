bool isPalindrome(struct ListNode* head){
    struct ListNode* p=head;
    struct ListNode* q=head;
    //首先利用快慢指针找到链表中间节点
    while(q&&q->next!=NULL){
        p=p->next;
        q=q->next->next;
    }
    //将链表的后半段反转
    struct ListNode* cur,*temp=NULL;
    while(p){
        cur=p->next;
        p->next=temp;
        temp=p;
        p=cur;
    }
   // 将后半段反转的链表与前半段依次比较
    while(temp&&head){
        if(temp->val!=head->val)
            return false;
        temp=temp->next;head=head->next;
    }
    return true;
}


