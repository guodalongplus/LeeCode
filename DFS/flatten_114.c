/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
 
 //每遍历到一个节点需要把该节点的右子树放在左子树最右边的节点上，然后把结点的右子树换位左子树，左子树置为null,继续迭代


void flatten(struct TreeNode* root){
    while(root!=NULL){
        if(root->left==NULL){
            root=root->right;
        }else{
            struct TreeNode* cur=root->left;
                while(cur->right!=NULL){
                    cur=cur->right;
                }
                cur->right=root->right;
                root->right=root->left;
                root->left=NULL;
                root=root->right;
            
        }
        
    }

}
