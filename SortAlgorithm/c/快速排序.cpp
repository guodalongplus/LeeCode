#include<stdio.h> 
int getBaseInt(int arr[],int low,int high){
	int tmp=arr[low];
	while(low<high){
		while(low<high && arr[high]>=tmp) 
			high--;
		arr[low]=arr[high];
		while(low<high && arr[low]<=tmp)
			low++;
		arr[high]=arr[low];
	}
	arr[low]=tmp;
	return low;
}

void quickSort(int arr[],int low,int high){
	if(low<high){
		int index=getBaseInt(arr,low,high);
		quickSort(arr,0,index-1);
		quickSort(arr,index+1,high);
	}
}


int main(){
	int arr[] ={1,4,1,9,0,-9,44};
	int length=sizeof(arr)/sizeof(arr[0]);
	quickSort(arr,0,length-1);
	for(int i;i<length;i++){
		printf("%d  ",arr[i]);
	}
}
