//若不理解，建议根据样例画图想一下
/*算法思想：递归

设置区间长度为mid = loc - inleft，创建结点，值为postorder[postright]
左子树的后序遍历区间范围为[postleft, postleft + mid - 1]，中序遍历区间范围为[inleft, loc - 1]
右子树的后序遍历区间范围为[postleft + mid, postright - 1]，中序遍历区间范围为[loc + 1, inright]
root -> left = create(postorder,postleft, postleft + mid - 1,inorder,inleft, loc - 1);
root -> right = create(postorder,postleft + mid, postright - 1,inorder,loc + 1, inright);

*/
struct TreeNode* create(int* postorder,int postleft, int postright, int* inorder, int inleft, int inright)
{
    if(postleft > postright || inleft > inright)
        return NULL;
    struct TreeNode* root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    root -> val = postorder[postright];
    int loc;
    //中序遍历inorder寻找值为val的元素loc
    for(int i = inleft; i <= inright; i++)
        if(inorder[i] == root -> val)
        {
            loc = i;
            break;
        }
    int mid = loc - inleft;
    root -> left = create(postorder,postleft, postleft + mid - 1,inorder,inleft, loc - 1);
    root -> right = create(postorder,postleft + mid, postright - 1,inorder,loc + 1, inright);
    return root;
}
struct TreeNode* buildTree(int* inorder, int inorderSize, int* postorder, int postorderSize){
    return create(postorder,0,postorderSize - 1,inorder,0,inorderSize - 1);
}

