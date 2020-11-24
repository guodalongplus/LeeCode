/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
 #define MAX_SIZE 1024
int* intersection(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize){
    /*��ʼ������
     int* hash=(int*)calloc(MAX_SIZE,sizeof(int));
     int* res= (int*)calloc(MAX_SIZE,sizeof(int));
     calloc�ڲ�����malloc �ٸ�ֵ0������û�� malloc ��Ч 
    */

    int* hash=malloc(sizeof(int) * MAX_SIZE);//��¼Ԫ�س��ִ���
    memset(hash,0,sizeof(int) * MAX_SIZE);
    int* res=malloc(sizeof(int) * MAX_SIZE);//��¼Ԫ�س��ִ���
    memset(res,0,sizeof(int) * MAX_SIZE);
    for(int i=0;i<nums1Size;i++){//���ظ����Ԫ�ص���ϣ��
        if(hash[nums1[i]]==0)
            hash[nums1[i]]++;
    }
    *returnSize=0;
    for(int j=0;j<nums2Size;j++){
        if(hash[nums2[j]]){
            hash[nums2[j]]--;//�ҵ��ظ���Ԫ�غ��Ȱѹ�ϣ���Ԫ�صĸ�����һ(��λ0)
            res[(*returnSize)++]=nums2[j];//����Ӹ�Ԫ�ص�������
        }
    }
    free(hash);
    return res;
}
