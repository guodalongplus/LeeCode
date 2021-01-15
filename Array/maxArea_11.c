/*
题目：11. 盛最多水的容器
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器

题解：
双指针法：两个指针的初始位置位于数组首和尾，每次移动指针所指长度短的木板，（移动长木板不能保证容量有增大的情况）计算容量取最小。
时间复杂度:o(N) 
*/ 
int max(int a,int b){
    return a>b?a:b;
}
int min(int a,int b){
    return a<b?a:b;
    }
int maxArea(int* height, int heightSize){
    int l=0;
    int r=heightSize-1;
    int ans=-1;
    while(l<=r){
        ans=max(ans,(r-l)*min(height[l],height[r]));
        if(height[l]>height[r]){
            r--;
        }else{
            l++;
        }
       
       
    }
    return ans;
}
