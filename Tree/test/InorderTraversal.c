int* inorderTraversal(struct TreeNode* root, int* returnSize) {
    *returnSize = 0;
    int* res = malloc(sizeof(int) * 501);//开辟返回的数组空间和 结构体数组空间 
    struct TreeNode** stk = malloc(sizeof(struct TreeNode*) * 501);
    int top = 0;
    while (root != NULL || top > 0) {
        while (root != NULL) {  //首先把每个结点下的整个左支路存储到结构体数组中 
            stk[top++] = root;
            root = root->left;
        }
        root = stk[--top];//每在数组退回一步把结点的值保存起来， 
        res[(*returnSize)++] = root->val;
        root = root->right; //把根节点更换为 该节点的右节点， 
    }
    return res;//最后数组中没有结点并且root为null是返回保存节点值的数组。· 
}


