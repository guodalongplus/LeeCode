
int comp(const void* a, const void* b)
{
    return *(int*)a - *(int*)b;
}
int other[2] = {-1, -1};
int* subSort(int* array, int arraySize, int* returnSize){
    int end = arraySize - 1;
    int first = 0;
    if ((array == NULL) || (arraySize <= 2)){
        printf("2\n");
        *returnSize = 2;
        return other;
    }
    int* res = (int*)malloc(sizeof(int) * arraySize);
    int* stop = (int*)malloc(sizeof(int) * arraySize);
    memset(stop, 0, sizeof(int) * arraySize);
    //����ԭ���� 
    for (int i = 0; i < arraySize; i++){
        res[i] = array[i];
    }
    qsort(res, arraySize, sizeof(int), comp);
    //��ǰ����ɨ�裬�ҵ�����ͬ���Ǹ���
    for (int i = 0; i< arraySize;i++){
        if (array[i] == res[i]){
            first++;
        }
        else{
            break;
        }
    }

    if (first == arraySize){
        *returnSize = 2;
        return other;       
    }
    //�Ӻ���ǰɨ�裬�ҵ�����ͬ��λ��
    for (int i = arraySize - 1; i>= 0;i--){
        if (array[i] == res[i]){
            end--;
        }
        else{
            break;
        }
    }

    stop[0] = first;
    stop[1] = end;
    *returnSize = 2;
    return stop;
}

