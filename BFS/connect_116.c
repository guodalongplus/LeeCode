/**
 * Definition for a Node.
 * struct Node {
 *     int val;
 *     struct Node *left;
 *     struct Node *right;
 *     struct Node *next;
 * };
 */

struct Node* connect(struct Node* root) {
	if(root==NULL) return root;
    struct Node* fromLeft=root;
    while(fromLeft->left!=NULL){
        struct Node* toNext=fromLeft;
        while(toNext!=NULL){
        	//���ڵ���ͬʱֱ���޸� 
            toNext->left->next=toNext->right;
            //���ڵ㲻ͬʱͨ�����ڽ���nextΪ�����ǽ�����ϵ 
            if(toNext->next!=NULL){
                toNext->right->next=toNext->next->left;
            }
            toNext=toNext->next;//������ò���Ҳ��ƶ� 
        }
        fromLeft=fromLeft->left;//����һ�������࿪ʼ 
    }
    return root;
}
