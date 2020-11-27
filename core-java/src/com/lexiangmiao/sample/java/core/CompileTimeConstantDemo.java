package com.lexiangmiao.sample.java.core;

import java.util.Arrays;

/**
 * javap -c 命令查看对应生成的字节码文件c直接被赋值为常量值替换后的ab
 * 因为若常量值在第3方包，若修改了，依赖它的应用则需要重新发布。否则会有安全问题
 */
public class CompileTimeConstantDemo {

    public static void main(String[] args) {
        String c = CompileTimeConstant.a + "b";
//        System.out.println(CompileTimeConstant.a);
        System.out.println(c);

    }

}

class CompileTimeConstant {
    public static final String a = "a";
}
