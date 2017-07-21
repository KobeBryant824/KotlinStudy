package com.example.cxh.kotlinstudy.kotlin.kt09_singleton.java;

// 单例1
public class LazyNotThreadSafe {
    private static LazyNotThreadSafe INSTANCE;

    private LazyNotThreadSafe(){}

    public static LazyNotThreadSafe getInstance(){
        if(INSTANCE == null){
            INSTANCE = new LazyNotThreadSafe();
        }
        return INSTANCE;
    }
}
