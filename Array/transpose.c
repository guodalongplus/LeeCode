#include <stdio.h>
#include <stdlib.h>

/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */

int** transpose(int** A, int ASize, int* AColSize, int* returnSize, int** returnColumnSizes) {
	//����һ����СΪ AColSize������ 
	int** num=(int**)malloc(sizeof(int*)**AColSize);
	*returnColumnSizes=(int*)malloc(sizeof(int)**AColSize);
	*returnSize=*AColSize;
	
	for(int i=0; i<*AColSize; i++) {
		num[i]=(int*)malloc(sizeof(int)*ASize);//��ÿ��λ���ٿ���һ����СΪ ASize������ 
		(*returnColumnSizes)[i]=ASize;
	}
	for(int i=0; i<ASize; i++) {
		for(int j=0; j<*AColSize; j++) {
			num[j][i]=A[i][j];
		}
	}
	return num;


}



