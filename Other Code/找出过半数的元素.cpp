#include<stdio.h>
int majorityElement(int* nums, int numsSize) {
	int res = nums[0], count = 1;
	/*找出可疑元素:要找元素要过半数,要么它至少会连续2次要么不连续出现的话末尾元素一定是他，但是最后可能不是(元素的个数相等)*/
	for(int i = 1; i < numsSize; i++) {
		if(nums[i]==res) {
			count++;
			continue;
		}
		if(--count==0) {
			count = 1;
			res = nums[i];
		}
	}
	/*无需验证直接返回*/
	if(count > numsSize / 2)
		return res;
	/*验证可疑元素*/
	count = 0;
	for(int i = 0; i < numsSize; i++)
		if(nums[i] == res)
			count++;
	if(count > numsSize / 2)
		return res;
	return -1;
}
int main(){
	int nums1[]= {3,2,3};
	int nums2[]= {3,2,3,2};
	printf("结果为:%d\n",majorityElement(nums1,3));
	printf("结果为:%d\n",majorityElement(nums2,4));
}
