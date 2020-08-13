#include<stdio.h>
#include<string.h>


int lengthOfLongestSubstring(char * s) {
	int i, j = 0, count = 0, max = 0, index[128] = {0}, start = 0;
	for(i=0; s[i]!='\0'; i++) {
		if(index[s[i]]>start) { //index������������ظ��ַ�ʱ
			//�Ӵ���ʼ�±�Ӧ�ƶ����ĵط�
			count = i-start;
			if(count>max) {
				max = count;
			}
			start = index[s[i]];
		}
		index[s[i]] = i+1;
	}
	count = i-start;
	return count>max?count:max;

}

int main(){
	char arr[]={'a','c','c','e','b','d','d'};
	printf("��󳤶�:%d",lengthOfLongestSubstring(arr));
}
