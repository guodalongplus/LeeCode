
int* sortedSquares(int* A, int ASize, int* returnSize) {
//˫ָ�뷨�����׺�β��ʼ�Ƚϣ���Ϊ��С��������ƽ�����������ƽ����Ҫ�󣬱Ƚ���λ���Ա���������� 
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
