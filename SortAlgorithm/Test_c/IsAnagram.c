#include<stdio.h>
#include<string.h>
#include <stdlib.h>

/* 1.define是预编译指令，而const是普通变量的定义
在给函数传参时，为了防止在函数内部改变形参的值（指针所指向的值）
   2. strcmp() 函数用于对两个字符串进行比较（区分大小写）。

*/
int cmp(const void *a,const void *b) {
	return *(char*)a-*(char*)b;
}
int isAnagram(char *s,char *t){
	if(!s || !t) return 0;
	qsort(s,strlen(s),sizeof(char),cmp);
	qsort(t,strlen(t),sizeof(char),cmp);
	return strcmp(s,t)==0?1:0;
}
int main() {
	char s[]="eat";
	char t[]="ayt";
	printf("answer is :%d",isAnagram(s,t));
//	return 0;
}
