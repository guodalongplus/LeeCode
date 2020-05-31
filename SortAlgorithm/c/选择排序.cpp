#include<stdio.h>
 void selectSort(int arr[],int n){
 	for(int i=0;i<n-1;i++){
 		int index=i;
 		int j;
 		for(j=i+1;j<n;j++){
 			if(arr[j]<arr[index]){
 				index=j;
			 }
		 }
		 int tmp=arr[index];
		 arr[index]=arr[i];
		 arr[i]=tmp;
	 }
 } 
 int main(){
 	int arr[]={2,12312,-657,3,1,43};
 	int length=sizeof(arr)/sizeof(arr[0]);
 	selectSort(arr,length);
 	printf("ÅÅÐòÍêµÄË³Ðò:");
 	for(int i=0;i<length;i++){
 		printf("%d  ",arr[i]); 
	 } 
 }
