package com.leecode.String;

/*520.检测大写字母
给定一个单词，你需要判断单词的大写使用是否正确。

我们定义，在以下情况时，单词的大写用法是正确的：

全部字母都是大写，比如"USA"。
单词中所有字母都不是大写，比如"leetcode"。
如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。

著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class DetectCapitalUse {
    public boolean detectCapitalUse(String word) {
        char[] STR = word.toCharArray();
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        //a-z 97-122  A-Z 65-90
        //第一种情况：全为大写
        for (char i : STR) {
            if ('A' > i || i > 'Z') {
                flag1 = false;
            }
        }
        //第二种情况：首字母大写
        if ('A' <= STR[0] && STR[0] <= 'Z') {
            for (char i=1;i<STR.length;i++ ){
                if ('a' <=STR[i] && STR[i] <= 'z') {
                }else {
                    flag3=false;
                }
            }
        }else{flag3=false;}

        //第三种情况：全为小写
        for (char j : STR) {
            if ('a' >j || j > 'z'){
                flag2 = false;
            }
        }
            return flag1 ||flag2||flag3;
    }

    public boolean detectCapitalUse01(String word) {
        return  word.equals(word.toLowerCase())||word.equals(word.toUpperCase())||word.equals(Character.toUpperCase(word.charAt(0))+word.substring(1).toLowerCase());
    }



    public static void main(String[] args) {
//        String str="Google";
//        String str="fffF";
        String str="DALONG";
//        String str="Dalong";
        char[] STR=str.toCharArray();
        DetectCapitalUse detectCapitalUse =new DetectCapitalUse();
        System.out.println(detectCapitalUse.detectCapitalUse(str));
    }
}
