package com.leecode.DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class diffWaysToCompute_241 {
    public static List<Integer> diffWaysToCompute(String input) {
        return partition(input);

    }
    //分割函数
    public static List<Integer> partition(String input){
        List<Integer> result=new ArrayList<>();
        //此时只有数字时，就返回该值
        if(!input.contains("+")  &&  !input.contains("-") &&  !input.contains("*")){
            result.add(Integer.valueOf(input));
            return result;
        }

        for(int i=0;i<input.length();i++){
            //发现有运算符时，运算符左侧的结果与右侧结果进行运算
            if(input.charAt(i)=='+'  || input.charAt(i)=='-'  || input.charAt(i)=='*'){
                for(Integer left:partition(input.substring(0,i))){
                    for(Integer right:partition(input.substring(i+1))){
                        if(input.charAt(i)=='+'){
                            result.add(left+right);
                        }else if(input.charAt(i)=='-'){
                            result.add(left-right);
                        }else{
                            result.add(left*right);
                        }
                    }
                }
            }
        }
        //返回左侧/右侧的运算结果集
        return result;
    }
    public static void main(String[] args) {
        String s="1+3*2-1";

        System.out.println(diffWaysToCompute(s));
    }


}
