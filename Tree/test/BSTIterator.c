#include<stdio.h>
#include<stdlib.h>
#define LEN 10000
typedef struct TreeNode{
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
}TreeNode;

int res[LEN];
//����������
typedef struct {
	int head;
	int tail;
} BSTIterator;
//��������ʵ�ֱ����м���
void traverse( TreeNode* root, BSTIterator* obj) {
	if(root == NULL) return;
	traverse(root->left, obj);
	res[(obj->tail)++] = root->val;
	traverse(root->right, obj);
	return;
}

BSTIterator* bSTIteratorCreate( TreeNode* root) {
	BSTIterator* obj = (BSTIterator*)malloc(sizeof(BSTIterator));//������������ռ�
	memset(obj, 0, sizeof(BSTIterator));//���ʻ�������
	obj->head = 0;
	obj->tail = 0;
	traverse(root, obj);//������������е��ֵ
	return obj;
}

/** @return the next smallest number */
int bSTIteratorNext(BSTIterator* obj) {
	return res[(obj->head)++];//����һ����Сֵ�����Լ�һ
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
