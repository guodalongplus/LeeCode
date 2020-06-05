package com.leecode.Search;
/*
* 1095. 山脉数组中查找目标值
（这是一个 交互式问题 ）

给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。

如果不存在这样的下标 index，就请返回 -1。
* */
class MountainArray {
    public MountainArray(int[] arr) {
        this.arr = arr;
    }
    private int [] arr;
      public int get(int index) {return arr[index];}
      public int length() {return arr.length;}
  }
public class FindInMountainArray {

    public FindInMountainArray() {

    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        //找到峰值下标i
        int i = binarySearchTop(mountainArr, 0, n);
        //二分查找
        int res1 = binarySearch1(mountainArr, 0, i + 1, target);
        int res2 = binarySearch2(mountainArr, i + 1, n, target);
        return res1 == -1 ? res2 : res1;
    }

    private int binarySearchTop(MountainArray mountainArr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            //此时峰值在mid右侧
            if (mid + 1 < mountainArr.length() && mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                return binarySearchTop(mountainArr, mid + 1, right);
            } else {
                return binarySearchTop(mountainArr, left, mid);
            }
        }
        return left;
    }

    private int binarySearch1(MountainArray mountainArr, int left, int right, int target) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) > target) {
                return binarySearch1(mountainArr, left, mid, target);
            } else {
                return binarySearch1(mountainArr, mid + 1, right, target);
            }
        }
        return -1;
    }

    private int binarySearch2(MountainArray mountainArr, int left, int right, int target) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) > target) {
                return binarySearch2(mountainArr, mid + 1, right, target);
            } else {
                return binarySearch2(mountainArr, left, mid, target);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MountainArray mountainArr=new MountainArray(new int[]{4, 5, 6, 7, 8, 9, 1, 2, 3, 4,});
        FindInMountainArray f=new FindInMountainArray();
        System.out.println(f.findInMountainArray(3,mountainArr));

    }


}
