#include<stdio.h>
#include<string.h>
#include <stdlib.h>

/* 1.define��Ԥ����ָ���const����ͨ�����Ķ���
�ڸ���������ʱ��Ϊ�˷�ֹ�ں����ڲ��ı��βε�ֵ��ָ����ָ���ֵ��
   2. strcmp() �������ڶ������ַ������бȽϣ����ִ�Сд����

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
