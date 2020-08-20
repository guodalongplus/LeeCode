#include<stdio.h>
#include<stdlib.h>
struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
};

int* preorderTraversal(struct TreeNode* root, int* returnSize) {/*returnSize��ϵͳ������󷵻����鳤��*/ 
	int retIndex = 0;
	int *ret = (int *)malloc(sizeof(int) * 100);
	memset(ret, 0, sizeof(int) * 100);//��Ԫ�س�ʼ��Ϊ0

	PreOrder(root, ret, &retIndex);
	*returnSize = retIndex;			//ָ����������ĳ���

	return ret;

}
void PreOrder(struct TreeNode *root, int *ret, int *retIndex) {
	if (root == NULL) {//�ý��Ϊ�յĻ�ֱ�ӽ���ִ�������� 
		return;
	}
	ret[(*retIndex)++] = root->val;  		//ǰ
	PreOrder(root->left, ret, retIndex);	//��
	PreOrder(root->right, ret, retIndex);	//��
}



