struct ListNode* reverseBetween(struct ListNode* head, int m, int n){
 if (m == n)
        return head;

    struct ListNode *prev = NULL, *next = NULL, *p = head;

    struct ListNode *left = NULL, *right = NULL;
    int count = 1;
    while (p != NULL && count <= n)
    {
        next = p->next;
        if (count == m)
        {
            left = prev;
            right = p;
        }
        if (count >= m)
            p->next = prev;

        if (count == n)
        {
            if (left != NULL)
                left->next = p;
            right->next = next;

            if (m == 1)
                head = p;
        }
        prev = p;
        p = next;
        count++;
    }
    return head;



}
