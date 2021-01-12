//学习:
/*
要找到多余的边，需要知道边的两个端点是不是属于一个类别（不断网上查找如果他们有共同的boss说明他们一类）
并查集包括合并和查找，合并：为了方便查找合并的是原本不是一个类的元素；查找：查找的是该点的boss;
所以通过并查集可以有效解决这个问题，我们找到两个点的boss是相同的一个点，说明我们可以通过其他方式可以将该两点进行连接，
所以，这两点之间的边就是多余的。
时间复杂度：o(N)*/
#define Max 1001
int Groups[Max];
//编号 
void InitGroups()
{
    for (size_t i = 0; i < Max; i++) {
        Groups[i] = i;
    }
}
//c查找操作：找到自己的boss 
int Find(int id)
{
    if (id == Groups[id]) {
        return id;
    }
    return Groups[id] = Find(Groups[id]);
}

int *findRedundantConnection(int **edges, int edgesSize, int *edgesColSize, int *returnSize)
{
    if (edges == NULL || edgesColSize == NULL || returnSize == NULL) {
        return NULL;
    }
    int *result = (int*)malloc(sizeof(int) * 2);
    if (result == NULL) {
        return NULL;
    }
    
    InitGroups();
    int u, v, uGroupId, vGroupId;
    for (int i = 0; i < edgesSize; i++) {
        u = edges[i][0];
        v = edges[i][1];
        uGroupId = Find(u);
        vGroupId = Find(v);

        if (uGroupId == vGroupId) {
            result[0] = u;
            result[1] = v;
            break;
        }
        //合并操作：两个点的boss不同时，选一个点当另一个点的boss 
        Groups[uGroupId] = vGroupId;
    }

    *returnSize = 2;
    return result;
}
