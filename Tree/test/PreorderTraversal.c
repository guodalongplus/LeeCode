#include<stdio.h>
#include<stdlib.h>
struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
};

int* preorderTraversal(struct TreeNode* root, int* returnSize) {/*returnSize是系统参数最后返回数组长度*/ 
	int retIndex = 0;
	int *ret = (int *)malloc(sizeof(int) * 100);
	memset(ret, 0, sizeof(int) * 100);//将元素初始化为0

	PreOrder(root, ret, &retIndex);
	*returnSize = retIndex;			//指定返回数组的长度

	return ret;

}
void PreOrder(struct TreeNode *root, int *ret, int *retIndex) {
	if (root == NULL) {//该结点为空的话直接结束执行另个结点 
		return;
	}
	ret[(*retIndex)++] = root->val;  		//前
	PreOrder(root->left, ret, retIndex);	//左
	PreOrder(root->right, ret, retIndex);	//右
}



