
struct TreeNode {
     int val;
     struct TreeNode *left;
     struct TreeNode *right;
 };
//从根节点的左右子树进行计数 
int height(struct TreeNode* root) {
    if (root == NULL) {
        return 0;
    } else {
        return fmax(height(root->left), height(root->right)) + 1;
    }
}

bool isBalanced(struct TreeNode* root) {
    if (root == NULL) {//根节点为空，也是平衡树 
        return true;
    } else {
        return fabs(height(root->left) - height(root->right)) <= 1 && isBalanced(root->left) && isBalanced(root->right);
    }
}









