#define MAX 10000
int findBottomLeftValue(struct TreeNode* root){
    struct TreeNode* queue[MAX];
    struct TreeNode* node;
    int head=0;
    int tail=0;
    int cur=0;
    queue[tail++]=root;
    while(head<tail){
        int size=tail-head;
        for(int i=0;i<size;i++){
            node=queue[head++];//³ö¶ÓÁÐ
            if(node->right){
                queue[tail++]=node->right;
            }
            if(node->left){
                queue[tail++]=node->left;
            }
        }
        
    }
    return node->val;
}
