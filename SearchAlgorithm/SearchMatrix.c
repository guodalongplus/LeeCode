#include <stdio.h>
int searchMatrix(int** matrix, int matrixSize, int matrixColSize, int target){
    if (!matrixSize || !matrixColSize) return 0;  // ����
    int left = 0, right = (matrixColSize) * matrixSize - 1, mid;
    int row, column;  // ��������
    while (left <= right) {
        mid = left + ((right - left) >> 1);
        row = mid / matrixColSize;  // ����ȡ����(��λ����)
        column = mid % matrixColSize;  // ȡ��õ���(��λ����)
        if (matrix[row][column] == target) return 1;
        else if (matrix[row][column] > target) right = mid - 1;
        else left = mid + 1;
    }
    return 0;
}



