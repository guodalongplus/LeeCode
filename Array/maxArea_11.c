/*
��Ŀ��11. ʢ���ˮ������
���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ���� (i, ai) ���������ڻ� n ����ֱ�ߣ���ֱ�� i �������˵�ֱ�Ϊ (i, ai) �� (i, 0) ���ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��
˵�����㲻����б����

��⣺
˫ָ�뷨������ָ��ĳ�ʼλ��λ�������׺�β��ÿ���ƶ�ָ����ָ���ȶ̵�ľ�壬���ƶ���ľ�岻�ܱ�֤������������������������ȡ��С��
ʱ�临�Ӷ�:o(N) 
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
