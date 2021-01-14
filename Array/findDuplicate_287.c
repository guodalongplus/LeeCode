
/*
��Ŀ��287. Ѱ���ظ���
����һ������ n + 1 ������������ nums �������ֶ��� 1 �� n ֮�䣨���� 1 �� n������֪���ٴ���һ���ظ���������
���� nums ֻ�� һ���ظ������� ���ҳ� ����ظ����� ��
˼·�� 
���û�г����ظ�����,��num[i]С�������i�����������ظ��������Ը����������С��������i,�����˵������У�
�����ҵ������￪ʼ�����ģ����ҵ����ظ������ݡ�
�ö��ַ�ʵ�֣�ÿ��ͳ��һ��С��Ŀǰ����ֵ���ݵĸ���������ø���С������ֵ˵��֮ǰ��mid֮ǰ����������,�ظ�ֵ�ڡ�mid,right����
������mid�Ļ���˵���ظ�ֵ�ڡ�left,mid��
ʱ�临�Ӷȣ�o(nlogn)
*/ 
int findDuplicate(int* nums, int numsSize){
    int ans;
    int l=1;
    int r=numsSize-1;
    int mid;
    while(l<=r){
        mid=(l+r)>>1;
        int count=0;
        for(int i=0;i<numsSize;i++){
            if(nums[i]<=mid){
                count++;
            }
        }
        if(count<=mid){
            l=mid+1;
        }else{
            r=mid-1;
            ans=mid;
        }
    }
    return ans;
}
