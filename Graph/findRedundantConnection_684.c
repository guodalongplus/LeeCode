//ѧϰ:
/*
Ҫ�ҵ�����ıߣ���Ҫ֪���ߵ������˵��ǲ�������һ����𣨲������ϲ�����������й�ͬ��boss˵������һ�ࣩ
���鼯�����ϲ��Ͳ��ң��ϲ���Ϊ�˷�����Һϲ�����ԭ������һ�����Ԫ�أ����ң����ҵ��Ǹõ��boss;
����ͨ�����鼯������Ч���������⣬�����ҵ��������boss����ͬ��һ���㣬˵�����ǿ���ͨ��������ʽ���Խ�������������ӣ�
���ԣ�������֮��ı߾��Ƕ���ġ�
ʱ�临�Ӷȣ�o(N)*/
#define Max 1001
int Groups[Max];
//��� 
void InitGroups()
{
    for (size_t i = 0; i < Max; i++) {
        Groups[i] = i;
    }
}
//c���Ҳ������ҵ��Լ���boss 
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
        //�ϲ��������������boss��ͬʱ��ѡһ���㵱��һ�����boss 
        Groups[uGroupId] = vGroupId;
    }

    *returnSize = 2;
    return result;
}
