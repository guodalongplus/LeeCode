int maxDepth(struct TreeNode* root){
    int left=1,right=1;//��������ļ����� ������ж�����֧·�ĸ��� 
    if(root==NULL)
        return 0;
    else
    {
        left+=maxDepth(root->left);
        right+=maxDepth(root->right);
    }
    return left>right?left:right;


