/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
struct TreeNode* create(int s,int t,int*nums){
    if(s>t){
        return NULL;
    }
    int mid=(s+t+1)/2;
    struct TreeNode* node=(struct TreeNode* )malloc(sizeof(struct TreeNode));
    node->val=nums[mid];
    node->left=create(s,mid-1,nums);
    node->right=create(mid+1,t,nums);
    return node;
}

struct TreeNode* sortedArrayToBST(int* nums, int numsSize){
    return create(0,numsSize-1,nums);

}
