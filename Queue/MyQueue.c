#define MaxSize 10000 //题干要求总操作数<=10000
//顺序实现
typedef struct {
    int *data;//数据域
    int front;//队列头
    int back;//队列尾

    int *hash;//维护一个降序的最大值队列--存放队列的下标，达成映射--
    int max;//最大值队列头
    int size;//最大值队列尾
} MaxQueue;

MaxQueue* maxQueueCreate() {
    MaxQueue *obj = (MaxQueue*)malloc(sizeof(MaxQueue));
    obj->data = (int*)malloc( MaxSize * sizeof(int) );
    obj->hash = (int*)malloc( MaxSize * sizeof(int) );
    memset(obj->data, 0, sizeof(obj->data));//各种初始化
    memset(obj->hash, 0, sizeof(obj->hash));
    obj->front = 0;
    obj->back = 0;
    obj->max = 0;
    obj->size = 0;
    return obj;
}

int maxQueueMax_value(MaxQueue* obj) {
    if (obj->front == obj->back){//判断队列是否空
        return -1;
    }
    return (obj->data[obj->hash[obj->max]]);//返回最大值
}

void maxQueuePush_back(MaxQueue* obj, int value) {
    for (obj->size--; (obj->size >= obj->max) && (obj->data[obj->hash[obj->size]] < value); obj->size--);
    //在 最大值队列中 寻找大于 value 的第一个元素，并覆盖删除小于value的元素
    //保持 最大值队列 的单调递减
    obj->size++;//跳过大于value的元素
    obj->hash[(obj->size)++] = obj->back;//保存value在队列中存放的位置
    obj->data[(obj->back)++] = value;//插入value进入队列
}

int maxQueuePop_front(MaxQueue* obj) {
    if (obj->front == obj->back){//判断队列是否空
        return -1;
    }
    if (obj->front == obj->hash[obj->max]){//如果删除的元素是当前队列的最大值
        obj->max++;//从最大值队列中删除
    }
    return (obj->data[obj->front++]);//返回删除元素值，并删除--两步操作
}

void maxQueueFree(MaxQueue* obj) {
    free(obj->data);
    obj->data = NULL;
    free(obj->hash);
    obj->hash = NULL;
    free(obj);
    obj = NULL;
}


