#include<stdio.h>

bool searchMatrix(int** matrix, int matrixRowSize, int matrixColSize, int target) {

        int row = 0;
        int col = matrixColSize-1;

        while (row <matrixRowSize && col >=0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else { // found it
                return true;
            }
        }

        return false;
    }
    
 
