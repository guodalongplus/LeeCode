int minSubArrayLen(int s, int* nums, int numsSize){
    if(numsSize==0){
        return 0;
    }
    int S=0;
    int E=0;
    int sum=0;
    int res=INT_MAX;
    while(E<numsSize){
        sum+=nums[E];
        while(sum>=s){
            res=fmin(res,E-S+1);//������̳���
            sum-=nums[S];
            S++;
        }
        //δ�ﵽSʱ�������Ѱ��
        E++;

    }
    return res==INT_MAX?0:res;
}
