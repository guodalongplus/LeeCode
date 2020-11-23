/**645. 错误的集合
 returned array must be malloced, assume caller calls free().
 */
int* findErrorNums(int* nums, int numsSize, int* returnSize){
    int* arr=malloc(sizeof(int) * numsSize);//记录元素出现次数
    memset(arr,0,sizeof(int) * numsSize);
    for(int i=0;i<numsSize;i++){
        arr[nums[i]-1]++;
    }
    for(int i=0;i<numsSize;i++){
        if(arr[i]==2){
            nums[0]=i+1;
        }
        if(arr[i]==0){
            nums[1]=i+1;
        }
    }
    free(arr);
    *returnSize=2;
    return nums;
}
