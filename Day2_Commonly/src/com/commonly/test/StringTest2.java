package com.commonly.test;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class StringTest2 implements Comparable{
    //获取两个字符串中最大的相同子串，比如：str1 = "abcsdhelloasixcsdaiecx" str2 = "sdahelloeeedse"
    //提示：将短的那个字串长度进行长度一次递减的子串与较长的串比较。
    //前提：字符串中只有一个最大相同字串
    public String getMaxSameString(String str1 ,String str2){
        if (str1 != null && str2 != null){
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            for (int i = 0;i <= minStr.length();i++){
                for (int x = 0,y = minStr.length() - i;y <= minStr.length();x++,y++){
                    String substring = minStr.substring(x, y);
                    if (maxStr.contains(substring)){
                        return substring;
                    }
                }
            }
        }
        return null;
    }

    public String[] getMaxSameString1(String str1 ,String str2){
        if (str1 != null && str2 != null){
            StringBuilder builder = new StringBuilder();
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            for (int i = 0;i <= minStr.length();i++){
                for (int x = 0,y = minStr.length() - i;y <= minStr.length();x++,y++){
                    String substring = minStr.substring(x, y);
                    if (maxStr.contains(substring)){
                        builder.append(substring+",");
                    }
                }
                //System.out.println(builder);
                if (builder.length() != 0){
                    break;
                }
            }
            String[] split = builder.toString().replaceAll(",$","").split("\\,");
            return split;
        }
        return null;
    }

    @Test
    public void test(){
       String str1 = "abcsdhello1asixcsdaiecxabcdef";
       String str2 = "sdahello1eeedseabcdef";
        String[] maxSameString = getMaxSameString1(str1, str2);
        System.out.println(Arrays.toString(maxSameString));
        new Comparator(){

            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
