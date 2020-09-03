#include<stdio.h>
#include<string.h>
void swap(int *a,int *b){
    int temp;
    temp=*a;
    *a=*b;
    *b=temp;
}
void sortColors(int* nums, int numsSize){
    int i=0;
    int j=numsSize-1;
    int cur=0;
    while(cur<=j){
        if(nums[cur]==0){
            swap(&nums[i],&nums[cur]);//如果当前为“0”与前指针交换 
            i++;
            cur++;
        }
        else if(nums[cur]==2){
            swap(&nums[j],&nums[cur]);//如果当前为“2”与后指针交换  
            j--;
        }
        else
            cur++; //如果当前为“1”，指针加一 
        
    }
}
//void sortColors(int* nums, int numsSize) {
//	int r=0;
//	int w=0;
//	int b=0;
//	for(int i=0; i<numsSize; i++) {
//		if(nums[i]==0) r+=1;
//		if(nums[i]==1) w+=1;
//		if(nums[i]==2) b+=1;
//	}
//	int j=0;
//	while(r>0) {
//		nums[j]=0;
//		j++;
//		r--;
//	}
//	while(w>0) {
//		nums[j]=1;
//		j++;
//		w--;
//	}
//	while(b>0) {
//		nums[j]=2;
//		j++;
//		b--;
//	}
//}

int main() {
	int nums[]= {2,0,2,1,1,0};
	sortColors(nums,6);
	for(int i=0;i<6;i++){
		printf("%d,",nums[i]);
	}

}
