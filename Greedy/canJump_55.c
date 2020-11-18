

bool canJump(int* nums, int numsSize){
    for(int i=0;i<numsSize-1;i++){
        if(nums[i]==0){
            int p=0;
            for(int j=0;j<i;j++){
                if(nums[j]>i-j){
                    p=1;
                }
            }
            if(p==0) return false;
        }
    }
    return true;
}
