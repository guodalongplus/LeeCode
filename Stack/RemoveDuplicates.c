#include<stdio.h>

char* myremove(char * S){
    int write=0;
    int read=0;
    char top; 
	char ch;                
    
    while(ch = S[read++]){
        if(0 == write){ // 初始化 
            top = 0;
        }else{
            top = S[write-1];
        }
        
        if(ch == top){ //字符相等的话 回退一个位置 
           write--;
        }else{ // write current character to top
            S[write++] = ch;           //不等的话入栈                       
        }                              
    }
    S[write] = 0;
    
    return S;
}

int main(){
	char S[]="abbaca";
	printf("%s",myremove(S));
	return 0;
}



