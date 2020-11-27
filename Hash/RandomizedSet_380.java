package com.leecode.HashTable;

import java.util.*;

class RandomizedSet_380 {
    Map <Integer,Integer> hash;
    List<Integer> list;
    Random random;
    public  RandomizedSet_380() {
        hash=new HashMap<>();
        list=new ArrayList<>();
        random=new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if(hash.containsKey(val)) return false;
        hash.put(val,list.size());
        list.add(list.size(),val);
        return true;
    }
    public boolean remove(int val) {
        if(!hash.containsKey(val)){
            return false;
        }
        int lastval=list.get(list.size()-1);//最后插入元素的值
        int index=hash.get(val);            //要删除元素的索引
        list.set(index,lastval);            //将list中val的位置的值更新为最后一个元素的值
        hash.put(lastval,index);

        hash.remove(val);
        list.remove(list.size()-1);         //删除重复的最后一个值
        return true;
    }
    public int getRandom() {
        if(list.size()==0){
            return 0;
        }
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet_380 obj = new RandomizedSet_380();
        System.out.println(obj.getRandom());
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(2));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.getRandom());

    }
}
