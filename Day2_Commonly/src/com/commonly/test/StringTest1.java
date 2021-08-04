package com.commonly.test;

import org.junit.Test;

public class StringTest1 {
    public int getCount(String mainStr ,String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if (mainLength >= subLength){
//            while ((index = mainStr.indexOf(subStr)) != -1){
//                count++;
//                mainStr = mainStr.substring(index + subLength);
            while ((index = mainStr.indexOf(subStr,index)) != -1){
                count++;
                index += subLength;
            }
            return count;
        }else {
            return 0;
        }
    }
    @Test
    public void getCountLength(){
        String x = "ab";
        String y = "abcderfabcsoabiiiascab";
        int count = getCount(y, x);
        System.out.println(count);
    }
}
