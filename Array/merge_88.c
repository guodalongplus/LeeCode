
/*
��Ŀ��88. �ϲ�������������
�������������������� nums1 �� nums2�����㽫 nums2 �ϲ��� nums1 �У�ʹ nums1 ��Ϊһ���������顣
��ʼ�� nums1 �� nums2 ��Ԫ�������ֱ�Ϊ m �� n ������Լ��� nums1 ���㹻�Ŀռ䣨�ռ��С���� m + n�������� nums2 �е�Ԫ�ء� 

˼·��
����ָ�룺1.ָ��arr1�����ݵ�β����2.ָ��arr2β����3.ָ��arr1β��
��Ϊ���������ж�������ģ������Ȳ��������ݣ�������������β�����бȽϣ��Ѵ�����ݷ���arr1β��ͬʱָ����ǰ�ƶ���
ʱ�临�Ӷȣ�o(n+m) 
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
