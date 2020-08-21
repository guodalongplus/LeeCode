#include<stdio.h>
#include<stdlib.h>
#define LEN 10000
typedef struct TreeNode{
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
}TreeNode;

int res[LEN];
//迭代器包括
typedef struct {
	int head;
	int tail;
} BSTIterator;
//遍历操作实现保存中间结点
void traverse( TreeNode* root, BSTIterator* obj) {
	if(root == NULL) return;
	traverse(root->left, obj);
	res[(obj->tail)++] = root->val;
	traverse(root->right, obj);
	return;
}

BSTIterator* bSTIteratorCreate( TreeNode* root) {
	BSTIterator* obj = (BSTIterator*)malloc(sizeof(BSTIterator));//给迭代器分配空间
	memset(obj, 0, sizeof(BSTIterator));//舒适化迭代器
	obj->head = 0;
	obj->tail = 0;
	traverse(root, obj);//中序遍历保存中点的值
	return obj;
}

/** @return the next smallest number */
int bSTIteratorNext(BSTIterator* obj) {
	return res[(obj->head)++];//返回一个最小值，并自加一
}

/** @return whether we have a next smallest number */
int bSTIteratorHasNext(BSTIterator* obj) {
	return obj->tail > obj->head?1:0;
}

void bSTIteratorFree(BSTIterator* obj) {
	if (obj != NULL)
		free(obj);
	return;
}

/**
 * Your BSTIterator struct will be instantiated and called as such:
 * BSTIterator* obj = bSTIteratorCreate(root);
 * int param_1 = bSTIteratorNext(obj);

 * bool param_2 = bSTIteratorHasNext(obj);

 * bSTIteratorFree(obj);
*/
