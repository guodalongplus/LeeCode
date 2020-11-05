#define MAXSIZE 10000
int** levelOrder(struct TreeNode* root, int* returnSize, int** returnColumnSizes){
    if(root == NULL)
    {
        *returnSize = 0;
        return;
    }
    int** result = (int**)malloc(sizeof(int*) * MAXSIZE);
    *returnColumnSizes = (int*)malloc(sizeof(int) * MAXSIZE);

    struct TreeNode* queue[10000];   //以下三步为初始化队列
    int rear = -1, front = -1;        
    queue[++rear] = root;

    int n = 0, level = 0;  //n用于每层的统计结点个数,level第几层 
    while(front != rear)
    {
        n = (rear - front % MAXSIZE);
        (*returnColumnSizes)[level] = n;
        result[level] = (int*)malloc(sizeof(int) * n);
        for(int i = 0; i < n; i++)
        {
            struct TreeNode* p = queue[++front]; //头指针后移 
            result[level][i] = p -> val;
            if(p -> left != NULL)
                queue[++rear] = p -> left;		//进栈尾指针后移 
            if(p -> right != NULL)
                queue[++rear] = p -> right;
        }
        level++;								//层数加一 
    }
    *returnSize = level;
    return result;
}


