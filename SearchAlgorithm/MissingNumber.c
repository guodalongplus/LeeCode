#include <stdio.h>
#include <string.h>
int missingNumber(int* nums, int numsSize){
      int i = 0, j = numsSize - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;

}

int main(){
	int nums[]={0,1,3};
	printf("%d",missingNumber(nums,3));
} 
