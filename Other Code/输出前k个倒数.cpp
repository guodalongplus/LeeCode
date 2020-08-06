#include<stdio.h>
#include<stdlib.h>
int cmp_up(const void *a, const void *b)
{
    return (*(int *)a - *(int *)b);
}

int *smallestK(int *arr, int arrSize, int k, int *returnSize)
{
    qsort(arr, arrSize, sizeof(int), cmp_up);
    *returnSize = k;
    return arr;
}



int main(){
	int num[]={5,7,6,3,1,2,4};
	int *returnSize=(int*)malloc(sizeof(int*));
	smallestK(num,7,3,returnSize);
	int len=sizeof(num)/sizeof(num[0]);
	printf("len:%d\n",len);
	for(int i=0;i<3;i++)
	printf("%d\n",num[i]);
} 
