
/*
题目：88. 合并两个有序数组
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 有足够的空间（空间大小等于 m + n）来保存 nums2 中的元素。 

思路：
三个指针：1.指向arr1放数据的尾部；2.指向arr2尾部；3.指向arr1尾部
因为两个子序列都是有序的，所以先插入大的数据，从两个子序列尾部进行比较，把大的数据放在arr1尾部同时指针向前移动。
时间复杂度：o(n+m) 
*/
void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n){
    int p=m+n-1;
    int p1=m-1;
    int p2=n-1;
    while(p1>=0 && p2>=0){
        nums1[p--]=nums1[p1]>nums2[p2]?nums1[p1--]:nums2[p2--];
    }
    while(p2>=0){
        nums1[p--]=nums2[p2--];
    } 

    } 
        

}
