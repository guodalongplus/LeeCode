#include<stdio.h>
#include <stdlib.h>
void quicksort(int* A,int left,int right){
    int i,j,t,tmp;
    if(left>right)
    return;
    tmp=A[left];
    i=left;
    j=right;
    while(i!=j){
        while(A[j]>=tmp&&i<j){
            j--;
        }
        while(A[i]<=tmp&&i<j){
            i++;
        }
        if(i<j){
            t=A[i];
            A[i]=A[j];
            A[j]=t;
        }
    }
    A[left]=A[i];
    A[i]=tmp;
    quicksort(A,left,i-1);
    quicksort(A,i+1,right);
}
int largestPerimeter(int* A, int ASize){
  quicksort(A,0,ASize-1);
  int sum=0;
  for(int i=ASize-1;i>=2;i--){
      if(A[i-1]+A[i-2]>A[i]){
          sum=A[i]+A[i-1]+A[i-2];
          break;
      }
  }
  return sum;
}
int main(){
	int arr[]={6,3,8,10};
//	int arr[]={2,2,4};
	printf("answer is %d",largestPerimeter(arr,3));
}

