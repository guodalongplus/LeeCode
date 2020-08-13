#include<stdio.h>
#include<string.h>
int countSubstrings(char * s) {
	int len=strlen(s);
	int ans=0;
	//�ڳ���Ϊ N ���ַ����У����ܵĻ��Ĵ�����λ���� 2N-2 ������ĸ(N��)����������ĸ�м�(N��)��
	for(int center=0; center<2*len-1; center++) {
		int left=center/2;
		int right=left+center%2;
		while(right<len && left>=0 && s[left]==s[right]) {
			ans++;
			left--;//����ÿ�����������ܽ���չ�� 
			right++;
		}
	}
	return ans;
}


int main() {
	char arr[]={'b','c','c','b'};
	char arr1[]={'b','b','b'};
	printf("�����ַ��ĸ���Ϊ:%d",countSubstrings(arr));

}
