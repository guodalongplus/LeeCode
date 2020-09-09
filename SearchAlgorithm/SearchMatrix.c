#include <stdio.h>
int searchMatrix(int** matrix, int matrixSize, int matrixColSize, int target){
    if (!matrixSize || !matrixColSize) return 0;  // 特判
    int left = 0, right = (matrixColSize) * matrixSize - 1, mid;
    int row, column;  // 代表行列
    while (left <= right) {
        mid = left + ((right - left) >> 1);
        row = mid / matrixColSize;  // 除法取整行(定位此行)
        column = mid % matrixColSize;  // 取余得到列(定位此列)
        if (matrix[row][column] == target) return 1;
        else if (matrix[row][column] > target) right = mid - 1;
        else left = mid + 1;
    }
    return 0;
}



