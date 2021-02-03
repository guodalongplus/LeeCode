 


/**
 *515. ��ÿ�������������ֵ
 
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 * Note: The returned array must be malloced, assume caller calls free().
 */
 void dfs(struct TreeNode* root,int depth,int* returnSize,int* ans){
     if(root==NULL) return ;
     if(depth>=*returnSize){   //��ǰ���� ��������ʱ���򿪱ٵ����Կռ������Ԫ�� 
         *(ans+(*returnSize)++)=root->val;
     }else{
         *(ans+depth)=fmax(*(ans+depth),root->val);//��ǰ����С����ʱ��˵���ò��Ѿ������������򿪸�λ�������ֵ���и��� 
     }
     dfs(root->left,depth+1,returnSize,ans);
     dfs(root->right,depth+1,returnSize,ans);
 }
int* largestValues(struct TreeNode* root, int* returnSize){
    int* ans=(int*)malloc(sizeof(int)*1e4);
    *returnSize=0;
    dfs(root,0,returnSize,ans);
    return ans;
}
