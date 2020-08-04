#include<stdio.h>
int majorityElement(int* nums, int numsSize) {
	int res = nums[0], count = 1;
	/*�ҳ�����Ԫ��:Ҫ��Ԫ��Ҫ������,Ҫô�����ٻ�����2��Ҫô���������ֵĻ�ĩβԪ��һ�����������������ܲ���(Ԫ�صĸ������)*/
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
	/*������ֱ֤�ӷ���*/
	if(count > numsSize / 2)
		return res;
	/*��֤����Ԫ��*/
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
	printf("���Ϊ:%d\n",majorityElement(nums1,3));
	printf("���Ϊ:%d\n",majorityElement(nums2,4));
}
