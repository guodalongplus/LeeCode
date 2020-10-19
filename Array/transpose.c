#include <stdio.h>
#include <stdlib.h>

/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */

int** transpose(int** A, int ASize, int* AColSize, int* returnSize, int** returnColumnSizes) {
	//开辟一个大小为 AColSize的数组 
	int** num=(int**)malloc(sizeof(int*)**AColSize);
	*returnColumnSizes=(int*)malloc(sizeof(int)**AColSize);
	*returnSize=*AColSize;
	
	for(int i=0; i<*AColSize; i++) {
		num[i]=(int*)malloc(sizeof(int)*ASize);//在每个位置再开辟一个大小为 ASize的数组 
		(*returnColumnSizes)[i]=ASize;
	}
	for(int i=0; i<ASize; i++) {
		for(int j=0; j<*AColSize; j++) {
			num[j][i]=A[i][j];
		}
	}
	return num;


}



