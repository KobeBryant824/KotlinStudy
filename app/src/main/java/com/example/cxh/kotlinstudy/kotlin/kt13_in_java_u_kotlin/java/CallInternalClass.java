package com.example.cxh.kotlinstudy.kotlin.kt13_in_java_u_kotlin.java;


import com.example.cxh.kotlinstudy.kotlin.kt13_in_java_u_kotlin.kotlin.InternalClass;

public class CallInternalClass{
    public static void main(String... args) {
        InternalClass internalClass = new InternalClass();
//        internalClass.printlnHello();//internal修饰类是可以访问的
//        internalClass.printlnHello$production_sources_for_module_app();//internal修饰方法就只能这行了但也是不能访问

//        com.example.internallib.InternalClass internalClass1 = new com.example.internallib.InternalClass();

    }
}