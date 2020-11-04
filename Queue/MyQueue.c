#define MaxSize 10000 //���Ҫ���ܲ�����<=10000
//˳��ʵ��
typedef struct {
    int *data;//������
    int front;//����ͷ
    int back;//����β

    int *hash;//ά��һ����������ֵ����--��Ŷ��е��±꣬���ӳ��--
    int max;//���ֵ����ͷ
    int size;//���ֵ����β
} MaxQueue;

MaxQueue* maxQueueCreate() {
    MaxQueue *obj = (MaxQueue*)malloc(sizeof(MaxQueue));
    obj->data = (int*)malloc( MaxSize * sizeof(int) );
    obj->hash = (int*)malloc( MaxSize * sizeof(int) );
    memset(obj->data, 0, sizeof(obj->data));//���ֳ�ʼ��
    memset(obj->hash, 0, sizeof(obj->hash));
    obj->front = 0;
    obj->back = 0;
    obj->max = 0;
    obj->size = 0;
    return obj;
}

int maxQueueMax_value(MaxQueue* obj) {
    if (obj->front == obj->back){//�ж϶����Ƿ��
        return -1;
    }
    return (obj->data[obj->hash[obj->max]]);//�������ֵ
}

void maxQueuePush_back(MaxQueue* obj, int value) {
    for (obj->size--; (obj->size >= obj->max) && (obj->data[obj->hash[obj->size]] < value); obj->size--);
    //�� ���ֵ������ Ѱ�Ҵ��� value �ĵ�һ��Ԫ�أ�������ɾ��С��value��Ԫ��
    //���� ���ֵ���� �ĵ����ݼ�
    obj->size++;//��������value��Ԫ��
    obj->hash[(obj->size)++] = obj->back;//����value�ڶ����д�ŵ�λ��
    obj->data[(obj->back)++] = value;//����value�������
}

int maxQueuePop_front(MaxQueue* obj) {
    if (obj->front == obj->back){//�ж϶����Ƿ��
        return -1;
    }
    if (obj->front == obj->hash[obj->max]){//���ɾ����Ԫ���ǵ�ǰ���е����ֵ
        obj->max++;//�����ֵ������ɾ��
    }
    return (obj->data[obj->front++]);//����ɾ��Ԫ��ֵ����ɾ��--��������
}

void maxQueueFree(MaxQueue* obj) {
    free(obj->data);
    obj->data = NULL;
    free(obj->hash);
    obj->hash = NULL;
    free(obj);
    obj = NULL;
}


