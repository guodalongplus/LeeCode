package com.leecode.String;

public class IisPalindrome {
        public static boolean isPalindrome(String s) {
            int n = s.length();
            int left = 0, right = n - 1;
            while (left < right) {//找到左右两端都不是除字符和数字的位置
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    ++left;
                }
                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    --right;
                }
                if (left < right) {
                    if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                        return false;
                    }
                    ++left;
                    --right;
                }
            }
            return true;
    }


    public static void main(String[] args) {
        String  ss="awawawa";
        System.out.println(isPalindrome(ss));
    }
}
