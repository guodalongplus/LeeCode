int* inorderTraversal(struct TreeNode* root, int* returnSize) {
    *returnSize = 0;
    int* res = malloc(sizeof(int) * 501);//���ٷ��ص�����ռ�� �ṹ������ռ� 
    struct TreeNode** stk = malloc(sizeof(struct TreeNode*) * 501);
    int top = 0;
    while (root != NULL || top > 0) {
        while (root != NULL) {  //���Ȱ�ÿ������µ�������֧·�洢���ṹ�������� 
            stk[top++] = root;
            root = root->left;
        }
        root = stk[--top];//ÿ�������˻�һ���ѽ���ֵ���������� 
        res[(*returnSize)++] = root->val;
        root = root->right; //�Ѹ��ڵ����Ϊ �ýڵ���ҽڵ㣬 
    }
    return res;//���������û�н�㲢��rootΪnull�Ƿ��ر���ڵ�ֵ�����顣�� 
}


