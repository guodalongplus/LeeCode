 


/**
 *515. 在每个树行中找最大值
 
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
     if(depth>=*returnSize){   //当前层数 大于容量时，向开辟的线性空间中添加元素 
         *(ans+(*returnSize)++)=root->val;
     }else{
         *(ans+depth)=fmax(*(ans+depth),root->val);//当前层数小容量时，说明该层已经填充过数，则向开该位置用最大值进行覆盖 
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
