#include<stdio.h>
#include<stdlib.h>
#define capacity 10000
typedef struct {
	int stack[capacity];
	int aux[capacity];
	int size;
} MinStack;

/** initialize your data structure here. */

MinStack* minStackCreate() {
	MinStack* minStack=(MinStack*)malloc(sizeof(MinStack));
	minStack->size=0;
	return minStack;
}

void minStackPush(MinStack* obj, int x) {
	(obj->stack)[obj->size]=x;
	//如果堆栈为空或者新值小于等于当前最小值,则入x
	if(obj->size==0||x<=(obj->aux)[obj->size-1]) {
		(obj->aux)[obj->size]=x;
	}else {	
			//否则，入当前最小值
		(obj->aux)[obj->size]=(obj->aux)[obj->size-1];
	}
	obj->size++;
}

void minStackPop(MinStack* obj) {
	obj->size--;
}mstack

int minStackTop(MinStack* obj) {
	return (obj->stack)[obj->size-1];
}

int minStackGetMin(MinStack* obj) {
	return (obj->aux)[obj->size-1];
}

void minStackFree(MinStack* obj) {
	free(obj);
}

int main() {
	MinStack* obj = minStackCreate();
	minStackPush(obj,2);
	minStackPush(obj, 0);
	minStackPush(obj, -1);
	minStackPush(obj, 9);
	minStackPush(obj, -9);
//	minStackPop(obj);
//	int param_1 = minStackTop(obj);
//	printf("top:%d\n",param_1);
	int param_2 = minStackGetMin(obj);
	printf("min:%d\n",param_2);
//	minStackPop(obj);
//	int param_2_1 = minStackGetMin(obj);
//	printf("min:%d\n",param_2_1);
//		minStackPop(obj);
//	printf("min:%d\n",minStackGetMin(obj));

for(int i=0;i<obj->size;i++){
	printf("元素:%d\n",obj->aux[i]);
}
	minStackFree(obj);


}
