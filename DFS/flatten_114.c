/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
 
 //ÿ������һ���ڵ���Ҫ�Ѹýڵ���������������������ұߵĽڵ��ϣ�Ȼ��ѽ�����������λ����������������Ϊnull,��������


void flatten(struct TreeNode* root){
    while(root!=NULL){
        if(root->left==NULL){
            root=root->right;
        }else{
            struct TreeNode* cur=root->left;
                while(cur->right!=NULL){
                    cur=cur->right;
                }
                cur->right=root->right;
                root->right=root->left;
                root->left=NULL;
                root=root->right;
            
        }
        
    }

}
