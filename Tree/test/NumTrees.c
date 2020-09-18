int numTrees(int n) {
    int G[n + 1];
    memset(G, 0, sizeof(G));//��ʼ������ 
    G[0] = G[1] = 1;		//0��1Ϊ���ڵ�ʱ ��ֻ��һ�� 
    for (int i = 2; i <= n; ++i) {
        for (int j = 1; j <= i; ++j) {
            G[i] += G[j - 1] * G[i - j]; //��ĳ��Ϊ���ڵ�ʱ�ĸ���=����ڵ�Ϊ�����ĸ���*���ҽڵ�Ϊ�����ĸ���  
        }
    }
    return G[n];
}

