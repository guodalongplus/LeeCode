int numTrees(int n) {
    int G[n + 1];
    memset(G, 0, sizeof(G));//初始化数组 
    G[0] = G[1] = 1;		//0和1为根节点时 都只有一种 
    for (int i = 2; i <= n; ++i) {
        for (int j = 1; j <= i; ++j) {
            G[i] += G[j - 1] * G[i - j]; //以某数为根节点时的个数=以左节点为根结点的个数*以右节点为根结点的个数  
        }
    }
    return G[n];
}

