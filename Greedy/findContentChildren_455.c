/*1��void *a ���ǿ�ָ�� ֻ��û�ж���ָ��ָ�������
��Ϊʲô�������أ��������ɶȴ�compar�����Զ��� �����Լ�ת��Ϊ��Ҫ������
2��const��ʾ������������Ϊ�˷�ָֹ��ָ������ݱ������޸ģ���������Ϊ��ֻ������������ָ��ָ������򲻿��޸ġ�*/ 
int compare(const void * a,const void *b){
    return (*(int*)a-*(int*)b);//ת��Ϊȷ�����ͺ�������Ƚ� 
}

int findContentChildren(int* g, int gSize, int* s, int sSize){
    qsort(g,gSize,sizeof(int),compare);
    qsort(s,sSize,sizeof(int),compare);
    int numbers=0;
        int j=0;
        for(int i=0;i<gSize;i++){
            while(j<sSize){
                if(s[j]>=g[i]){
                    numbers++;
                    j++;
                    break;
                }else{
                    j++; 
                }
            }
        }
            return numbers;
        }

