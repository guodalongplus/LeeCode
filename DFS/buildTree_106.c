//������⣬�������������ͼ��һ��
/*�㷨˼�룺�ݹ�

�������䳤��Ϊmid = loc - inleft��������㣬ֵΪpostorder[postright]
�������ĺ���������䷶ΧΪ[postleft, postleft + mid - 1]������������䷶ΧΪ[inleft, loc - 1]
�������ĺ���������䷶ΧΪ[postleft + mid, postright - 1]������������䷶ΧΪ[loc + 1, inright]
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
    //�������inorderѰ��ֵΪval��Ԫ��loc
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

