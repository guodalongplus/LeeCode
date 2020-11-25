package com.leecode.HashTable;

import java.util.*;

public class frequencySort_451 {
    public  static  String frequencySort(String s) {
        char[]chars=s.toCharArray();
        Map<Character,Integer> hash=new HashMap<>();
        for(char c:chars){
            if(hash.containsKey(c)){
                hash.put(c,hash.get(c)+1);
            }else{
                hash.put(c,1);
            }
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(hash.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        StringBuilder sortedString = new StringBuilder(s.length());
        for(int i=0;i<list.size();i++){
            char c=list.get(i).getKey();
            int count=list.get(i).getValue();
            while(count>0){
                // news+=c;
                count--;
                sortedString.append(c);
            }
        }
        return sortedString.toString();
    }

    public static void main(String[] args) {
        String s = "treee";
        System.out.println(frequencySort(s));
    }
}
