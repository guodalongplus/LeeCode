
struct ListNode* partition(struct ListNode* head, int x){
    struct ListNode* lessnode=malloc(sizeof(struct ListNode));
    struct ListNode* largenode=malloc(sizeof(struct ListNode));
    struct ListNode* less=lessnode;
    struct ListNode* large=largenode;
    while(head){
        if(head->val<x){
            less->next=head;
            less=head;
        }else{
            large->next=head;
            large=head;
        }
        head=head->next;
    }
    large->next=NULL;
    
    less->next=largenode->next;
    return lessnode->next;
}
