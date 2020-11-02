/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
//计算到x or y的深度
int get_dep(struct TreeNode *node, int x, int dep){
    if(!node) return -1;
    //加点不为空 深度加一
    if(node->val == x){
        return dep+1;
    }
    //分别从左右孩子寻找x，记录深度
    int l = get_dep(node->left, x, dep);
    if(l > 0) return l+1;
    
    int r = get_dep(node->right, x, dep);
    if(r > 0) return r+1;
    
    return -1;
}


//判断是否存在x与y节点为兄弟节点。

bool check(struct TreeNode *node, int x, int y){
    if(!node) return false;
    
    if(node->left && node->right && 
       node->left->val == x && node->right->val == y )
        return true;
    
    if(node->left && node->right && 
       node->left->val == y && node->right->val == x )
        return true;
//执行到这里说明还未找到符合条件的节点，继续递归寻找
    if(check(node->left, x, y) || check(node->right, x, y)){
        return true;
    } 

    return false;
}

bool isCousins(struct TreeNode* root, int x, int y){
    if(!root) return false;
    int x_d = get_dep(root, x, 0);
    int y_d = get_dep(root, y, 0);
    
    if(x_d == y_d && !check(root, x, y)) 
        return true;
    
    return false;
}


