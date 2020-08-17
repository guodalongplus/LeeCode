#include<stdio.h>
#include<stdlib.h>

#define MAXSIZE 100
//����ջ
struct Stack {
	int Data[MAXSIZE];
	int TOP;
};
typedef struct Stack MyStack;
//���ж���Ϊ˫ջ
typedef struct {
	MyStack S1; //S1Ϊ��ջ
	MyStack S2; //S2Ϊ������ת��ջ
} MyQueue;

/** Initialize your data structure here. */

MyQueue* myQueueCreate() {
	MyQueue* TempQueue=(MyQueue*)malloc(sizeof(MyQueue));
	TempQueue->S1.TOP=-1;
	TempQueue->S2.TOP=-1;
	return TempQueue;
}

/** Push element x to the back of queue. */
void myQueuePush(MyQueue* obj, int x) {

	if(obj->S1.TOP<MAXSIZE) { //ջ�Ƿ���
		while(obj->S1.TOP!=-1) {
			obj->S2.Data[++(obj->S2.TOP)]=obj->S1.Data[(obj->S1.TOP)--]; //��S1ջ��Ԫ��ѹ�븨��ջS2ʵ�ַ�ת
		}
		obj->S1.Data[++(obj->S1.TOP)]=x; //��push��Ԫ��ѹ��S1ջ����ʱS1Ϊ��ջ����Ϊ����Ԫ���Ѿ�ȫ����S2����
		while(obj->S2.TOP!=-1) {
			obj->S1.Data[++(obj->S1.TOP)]=obj->S2.Data[(obj->S2.TOP)--]; //�ٰ�S2ջ�е�Ԫ��ȫ����תѹ��S1
		}
	}

}

/** Removes the element from in front of queue and returns that element. */
int myQueuePop(MyQueue* obj) {
	if(obj->S1.TOP!=-1)
		return obj->S1.Data[(obj->S1.TOP)--];
	return NULL;
}

/** Get the front element. */
int myQueuePeek(MyQueue* obj) {
	if(obj->S1.TOP!=-1)
		return obj->S1.Data[obj->S1.TOP];
	return NULL;
}

/** Returns whether the queue is empty. */
int myQueueEmpty(MyQueue* obj) {
	if(obj->S1.TOP==-1)
		return 1;
	return 0;
}

void myQueueFree(MyQueue* obj) {
	free(obj);
}
int main() {
	MyQueue* obj = myQueueCreate();
	myQueuePush(obj, 8);
	myQueuePush(obj, 7);
	myQueuePush(obj, 6);
	int param_2 = myQueuePop(obj);
	printf("%d\n",param_2);
	int param_3 = myQueuePeek(obj);
	printf("%d\n",param_3);
	int param_4 = myQueueEmpty(obj);
	printf("%d",param_4);
	myQueueFree(obj);


}

