package com.java.test;

import org.junit.Test;

public class CallableTest {

    //题目:将一个字符串进行反转。将字符串中指定的部分进行反转比如“abcderg”转换为“abredcg”
    //方式一：转换为char[]
    public String reverse(String str,int startIndex,int endIndex){
        if (str != null){
            char[] arr = str.toCharArray();
            for (int x =  startIndex ,y = endIndex;x < y ;x++,y--){
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp ;
            }
            return new String(arr);
        }
        return null;
    }
    //方式二：使用String的拼接
    public String reverse1(String str,int startIndex,int endIndex){
        if (str != null){
            String reverseStr = str.substring(0,startIndex);
            for (int i = endIndex;i >= startIndex;i--){
                reverseStr += str.charAt(i);
            }
            reverseStr += str.substring(endIndex + 1);
            return reverseStr;
        }
        return null;
    }
    //方式三:试用StringBuilder/StringBuffer替换String
    public String reverse2(String str,int startIndex,int endIndex){
        if (str != null){
            StringBuilder builder = new StringBuilder(str.length());
            //第一部分
            builder.append(str.substring(0,startIndex));
            //第二部分
            for (int i = endIndex;i >= startIndex;i--){
                builder.append(str.charAt(i));
            }
            //第三部分
            builder.append(str.substring(endIndex +1));
            return builder.toString();
        }
        return null;
    }

    @Test
    public void text(){
        String s = "abcdefg";
        String reverse = reverse2(s, 2, 5);
        System.out.println(reverse);
    }

}
