bool isPalindrome(struct ListNode* head){
    struct ListNode* p=head;
    struct ListNode* q=head;
    //�������ÿ���ָ���ҵ������м�ڵ�
    while(q&&q->next!=NULL){
        p=p->next;
        q=q->next->next;
    }
    //������ĺ��η�ת
    struct ListNode* cur,*temp=NULL;
    while(p){
        cur=p->next;
        p->next=temp;
        temp=p;
        p=cur;
    }
   // �����η�ת��������ǰ������αȽ�
    while(temp&&head){
        if(temp->val!=head->val)
            return false;
        temp=temp->next;head=head->next;
    }
    return true;
}


