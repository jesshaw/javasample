package com.lexiangmiao.sample.springframework;

public class Test {
    public static void main(String[] args) {
String s1 = new String("zs");
String s2 = new String("zs");
System.out.println(s1 == s2); //false

String s3 = "zs";
String s4 = "zs";
System.out.println(s3 == s4); //true
System.out.println(s3 == s1); //false

String s5 = "zszs";
String s6 = s3+s4; //因为s3,s4变量指针可变,所以是走new StringBuilder
System.out.println(s5 == s6); //false

final String s7 = "zs";
final String s8 = "zs";
String s9 = s7+s8; //因为s7,s8变量不可变，统译优化后直接替换成了zszs
System.out.println(s5 == s9);//true

final String s10 = s3+s4; //因为s3,s4变量指针可变,所以是走new StringBuilder
System.out.println(s5 == s10);//false
    }
}


