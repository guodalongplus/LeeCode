#include<stdio.h>
#include<string.h>
int hash[256];
int cmp(const void*a,const void*b){
	char t_a=*(char*)a;
	char t_b=*(char*)b;
	if(hash[t_a]==hash[t_b]){
		return t_a-t_b;
	}
	return hash[t_b]-hash[t_a];
}
char * grequencySort(char *s){
	int len=strlen(s);
	memset(hash,0,sizeof(int)*256);
	for(int i=0;i<len;i++){
		hash[s[i]]++;
	}
	qsort(s,len,sizeof(char),cmp);
	return s;
}

