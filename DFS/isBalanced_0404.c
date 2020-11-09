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
    l=maxDepth(root->left,p_tmp);   //���������
    r=maxDepth(root->right,p_tmp);  //���������

    if(abs(l-r)>1)
    {
        *p_tmp=false;               //�����Ϊfalse
    }
    return max(l,r)+1;              //���ظ߶�
}
bool isBalanced(struct TreeNode* root){
    if(!root) return true;          //����Ϊƽ����
    bool tmp=true;
    maxDepth(root,&tmp);
    return tmp;
}

