/*1、void *a 不是空指针 只是没有定义指针指向的类型
它为什么不定义呢？这样自由度大，compar可以自定义 可以自己转换为需要的类型
2、const表示常量，这里是为了防止指针指向的内容被意外修改，所以设置为“只读”，即常量指针指向的区域不可修改。*/ 
int compare(const void * a,const void *b){
    return (*(int*)a-*(int*)b);//转化为确定类型后才能做比较 
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

