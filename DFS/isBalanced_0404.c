/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


int max(int a,int b){
    return a>b?a:b;
}
int maxDepth(struct TreeNode* root,bool *p_tmp){
    if(!root) return 0;
    int l,r;
    l=maxDepth(root->left,p_tmp);   //左子树深度
    r=maxDepth(root->right,p_tmp);  //右子树深度

    if(abs(l-r)>1)
    {
        *p_tmp=false;               //标记置为false
    }
    return max(l,r)+1;              //返回高度
}
bool isBalanced(struct TreeNode* root){
    if(!root) return true;          //空树为平衡树
    bool tmp=true;
    maxDepth(root,&tmp);
    return tmp;
}

