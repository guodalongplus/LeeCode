/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
 #define MAX_SIZE 1024
int* intersection(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize){
    /*初始化数组
     int* hash=(int*)calloc(MAX_SIZE,sizeof(int));
     int* res= (int*)calloc(MAX_SIZE,sizeof(int));
     calloc内部先是malloc 再赋值0，所以没有 malloc 高效 
    */

    int* hash=malloc(sizeof(int) * MAX_SIZE);//记录元素出现次数
    memset(hash,0,sizeof(int) * MAX_SIZE);
    int* res=malloc(sizeof(int) * MAX_SIZE);//记录元素出现次数
    memset(res,0,sizeof(int) * MAX_SIZE);
    for(int i=0;i<nums1Size;i++){//无重复添加元素到哈希表
        if(hash[nums1[i]]==0)
            hash[nums1[i]]++;
    }
    *returnSize=0;
    for(int j=0;j<nums2Size;j++){
        if(hash[nums2[j]]){
            hash[nums2[j]]--;//找到重复的元素后，先把哈希表该元素的个数减一(即位0)
            res[(*returnSize)++]=nums2[j];//再添加该元素到交集中
        }
    }
    free(hash);
    return res;
}
