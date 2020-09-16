int maxDepth(struct TreeNode* root){
    int left=1,right=1;//定义最初的计数器 ，最后判断左右支路哪个长 
    if(root==NULL)
        return 0;
    else
    {
        left+=maxDepth(root->left);
        right+=maxDepth(root->right);
    }
    return left>right?left:right;


