
#include<stdio.h>
struct ListNode{
	int val;
	struct Listnode *next; 
}; 

void deleteNode(struct ListNode* node) 
    //tmpָ��Ҫ�ͷŵĿռ�
    struct ListNode* temp = node->next;
    node->val = node->next->val;
    node->next = node->next->next;
    free(temp);

    //  struct ListNode *a = node->next;
    // *node = *a;
    // free(a);

}

