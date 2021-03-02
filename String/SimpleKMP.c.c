#include<stdio.h> 
#include<string.h>

int strStr(char * haystack, char * needle){
    int s1_len=strlen(haystack);
    int s2_len=strlen(needle);
    if(s2_len==0) return 0;
    int i=0;
    int j=0;
    while(j<s2_len && i<s1_len){
        if(haystack[i]==needle[j]){
            j++;
            if(j==s2_len) return i-s2_len+1;
        }else{
            i=i-j;
            j=0;    
        }
        i++;
        if(s2_len-j > s1_len-i) return -1;
    }
    return -1;
}
int main(){
	char* s1="abcdbbdeff";
	char* s2="dbb";
	printf("location:%d",strStr(s1,s2));
}
