/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* merges(struct ListNode* n1,struct ListNode* n2){
    if(n1==NULL) return n2;
    if(n2==NULL) return n1;
    struct ListNode* node=malloc(sizeof(struct ListNode*));
    if(n1->val<n2->val){
        node=n1;
        node->next=merges(n1->next,n2);
    }else{
        node=n2;
        node->next=merges(n1,n2->next);
    }
    return  node;
}

struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
    if(l1==NULL && l2==NULL ) return NULL;
    return merges(l1,l2);
}

