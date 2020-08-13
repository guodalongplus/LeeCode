#include<stdio.h>
#include<string.h>
int countSubstrings(char * s) {
	int len=strlen(s);
	int ans=0;
	//在长度为 N 的字符串中，可能的回文串中心位置有 2N-2 个：字母(N个)，或两个字母中间(N个)。
	for(int center=0; center<2*len-1; center++) {
		int left=center/2;
		int right=left+center%2;
		while(right<len && left>=0 && s[left]==s[right]) {
			ans++;
			left--;//对于每个中心向四周进行展开 
			right++;
		}
	}
	return ans;
}


int main() {
	char arr[]={'b','c','c','b'};
	char arr1[]={'b','b','b'};
	printf("回文字符的个数为:%d",countSubstrings(arr));

}
