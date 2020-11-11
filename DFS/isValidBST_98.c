/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

bool judge(struct TreeNode* root,struct TreeNode* L,struct TreeNode* R){
    if(root==NULL) return 1;
    if(L!=NULL && root->val<=L->val){
        return 0;
    }
    if(R!=NULL && root->val>=R->val){
        return 0;
    }
    return  judge(root->left,L,root) && judge(root->right,root,R);
}
bool isValidBST(struct TreeNode* root){
    return judge(root,NULL,NULL);
}
