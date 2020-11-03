#include<stdio.h> 
int fib(int n){
    int a = 0;
    int b = (n == 0) ? 0 : 1;   // 0 + 0 = 0  
    int res  =  a + b;         // 0 + 1 = 1
    int c = 1e9 + 7;
    for(int i = 0; i < n - 1; ++i){
        res  =  (a + b) % c;
        a = b ;//ÒÆ¶¯
        b = res;
    }
    return res;
}

int main(){
	printf("%d",fib(5));
}
