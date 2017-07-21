package com.example.cxh.kotlinstudy.kotlin.kt09_singleton.java;

// 饿汉式
public class PlainOldSingleton {
    private static PlainOldSingleton INSTANCE = new PlainOldSingleton();

    private PlainOldSingleton(){
        System.out.println("PlainOldSingleton");
    }

    public static PlainOldSingleton getInstance(){
        return INSTANCE;
    }
}
