#include<stdio.h>

char* myremove(char * S){
    int write=0;
    int read=0;
    char top; 
	char ch;                
    
    while(ch = S[read++]){
        if(0 == write){ // ��ʼ�� 
            top = 0;
        }else{
            top = S[write-1];
        }
        
        if(ch == top){ //�ַ���ȵĻ� ����һ��λ�� 
           write--;
        }else{ // write current character to top
            S[write++] = ch;           //���ȵĻ���ջ                       
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



