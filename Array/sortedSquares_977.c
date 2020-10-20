
int* sortedSquares(int* A, int ASize, int* returnSize) {
//双指针法：从首和尾开始比较，因为最小的数可能平方和最大数的平方和要大，比较首位可以避免这个问题 
	int i=0;                
	int j =ASize-1;       
	int cur=ASize-1;    
	int[] res=new int[ASize];
	int *res=(int*)malloc(sizeof(int)*ASize);
	while (i<=j) {
		if(A[i]*A[i]<A[j]*A[j]) {
			res[cur]=A[j]*A[j];
			j--;
		} else {
			res[cur]=A[i]*A[i];
			i++;
		}
		cur--;
	}
	*returnSize=ASize;
	return res;
}
