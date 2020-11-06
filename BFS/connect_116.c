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
        	//父节点相同时直接修改 
            toNext->left->next=toNext->right;
            //父节点不同时通过父节结点的next为孩子们建立关系 
            if(toNext->next!=NULL){
                toNext->right->next=toNext->next->left;
            }
            toNext=toNext->next;//继续向该层的右侧移动 
        }
        fromLeft=fromLeft->left;//从下一层的最左侧开始 
    }
    return root;
}
